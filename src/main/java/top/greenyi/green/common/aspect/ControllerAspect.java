package top.greenyi.green.common.aspect;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Green
 */
@Component
@Aspect
@Slf4j
public class ControllerAspect {

    /**
     * 对controller包下所有的类的所有方法增强
     */
    private final String execute = "execution(* top.greenyi.green.controller..*.*(..))";

    /**
     * 超过了这个时间，才打印
     */
    private long maxReduceTime = -1;

    /**
     * 环绕通知，拦截controller，输出请求参数、响应内容和响应时间
     * @param joinPoint
     * @return
     */
    @Around(execute)
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        // 获取方法名称
        String methodName = method.getName();
        // 获取参数名称
        LocalVariableTableParameterNameDiscoverer paramNames = new LocalVariableTableParameterNameDiscoverer();
        String[] params = paramNames.getParameterNames(method);
        // 获取参数
        Object[] args = joinPoint.getArgs();
        // 过滤掉request和response,不能序列化
        List<Object> filteredArgs = Arrays.stream(args)
                .filter(arg -> (!(arg instanceof HttpServletRequest) && !(arg instanceof HttpServletResponse)))
                .collect(Collectors.toList());
        JSONObject rqsJson = new JSONObject();
        rqsJson.put("requestMethod", methodName);
        rqsJson.put("requestTime", DateUtil.now());
        if (CollUtil.isEmpty(filteredArgs)) {
            rqsJson.put("requestParams", null);
        } else {
            // 拼接请求参数
            Map<String, Object> rqsParams = IntStream.range(0, filteredArgs.size())
                    .boxed()
                    .collect(Collectors.toMap(j -> params[j], j -> filteredArgs.get(j)));
            rqsJson.put("requestParams", rqsParams);
        }
        log.info("{}请求信息为: {}", methodName, rqsJson.toJSONString());
        Object response;
        long startTime = System.currentTimeMillis();
        response = joinPoint.proceed(args);
        long endTime = System.currentTimeMillis();
        // 打印耗时的信息
        this.printExecTime(methodName, startTime, endTime);
        return response;
    }

    /**
     * 打印方法执行耗时的信息，如果超过了一定的时间，才打印
     * @param methodName
     * @param startTime
     * @param endTime
     */
    private void printExecTime(String methodName, long startTime, long endTime) {
        long diffTime = endTime - startTime;
        if (diffTime > maxReduceTime) {
            log.info("{}方法执行耗时: {}ms", methodName, diffTime);
        }
    }
}
