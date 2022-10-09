package top.greenyi.green.common.utils;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.greenyi.green.bean.SysLog;
import top.greenyi.green.common.response.ResponseResult;
import top.greenyi.green.service.ISysLogService;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 系统日志工具类
 *
 * @author Green
 */
@Slf4j
@Component
public class SysLogUtils {

    @Autowired
    private ISysLogService sysLogService;

    private static final String LOCALHOST = "127.0.0.1";

    /**
     * 初始化系统未完成功能的字段
     *
     * @return 日志实体
     */
    private static SysLog init(long useTime) {
        SysLog sysLog = new SysLog();
        sysLog.setUseTime(useTime);
        sysLog.setCompanyId(1);
        sysLog.setIsDeleted("0");
        sysLog.setOperator(null);
        sysLog.setOperatorLogin(null);
        sysLog.setRoleName(null);
        sysLog.setRemark(null);
        sysLog.setCreateTime(DateTime.now());
        return sysLog;
    }

    /**
     * 解析请求组装到SysLog
     *
     * @param sysLog  日志实体
     * @param request 请求
     * @return 日志实体
     */
    private static SysLog parseRequest(SysLog sysLog, HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        SysLogUtils.log.info("X-Real-IP ip: {}", ip);
        if (StringUtils.isEmpty(ip) || SysLogUtils.LOCALHOST.equals(ip)) {
            ip = request.getHeader("X-Forwarded-For");
            SysLogUtils.log.info("X-Forwarded-For ip: {}", ip);
        }
        if (StringUtils.isEmpty(ip) || SysLogUtils.LOCALHOST.equals(ip)) {
            ip = request.getRemoteAddr();
            SysLogUtils.log.info("RemoteAddr ip: {}", ip);
        }
        String url = request.getRequestURI();
        sysLog.setIpAddress(ip);
        sysLog.setUrl(url);
        return sysLog;
    }

    /**
     * 解析切入点组装到SysLog
     *
     * @param sysLog    日志实体
     * @param joinPoint 切入点
     * @return 日志实体
     */
    private static SysLog parseJoinPoint(SysLog sysLog, ProceedingJoinPoint joinPoint) {
        // 获取类对象
        Class<?> controller = joinPoint.getThis().getClass();
        // 获取swagger接口对象
        Api annotation = controller.getAnnotation(Api.class);
        // 获取类接口的内容
        String tags = Arrays.toString(annotation.tags());
        // 获取方法
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
        String value = apiOperation != null ? apiOperation.value() : "";
        String httpMethod = apiOperation != null ? apiOperation.httpMethod() : "";
        sysLog.setModuleName(tags);
        sysLog.setFunctionName(value);
        sysLog.setFunctionMethod(httpMethod);
        return sysLog;
    }

    /**
     * 解析响应组装到SysLog
     *
     * @param sysLog   日志实体
     * @param response 响应
     * @return 日志实体
     */
    private static SysLog parseResponse(SysLog sysLog, Object response) {
        if (response instanceof ResponseResult) {
            ResponseResult responseResult = (ResponseResult) response;
            sysLog.setResponseStatus(responseResult.getStatus().toString());
            sysLog.setResponseMessage(responseResult.getMessage());
            // 数据库字段ResponseData长度255
            Object data = responseResult.getData();
            if (data != null) {
                sysLog.setResponseData(StrUtil.sub(data.toString(), 0, 255));
            }
        }
        return sysLog;
    }

    /**
     * 保存日志
     *
     * @param joinPoint 切入点
     * @param response  响应数据
     * @param useTime   耗时
     */
    public void saveLog(ProceedingJoinPoint joinPoint, HttpServletRequest request, Object response, long useTime) {
        try {
            // 初始化系统未完成功能的字段
            SysLog sysLog = SysLogUtils.init(useTime);
            // 解析请求组装到SysLog
            SysLog requestLog = SysLogUtils.parseRequest(sysLog, request);
            // 解析切入点组装到SysLog
            SysLog joinPointLog = SysLogUtils.parseJoinPoint(requestLog, joinPoint);
            // 解析响应组装到SysLog
            SysLog responseLog = SysLogUtils.parseResponse(joinPointLog, response);
            // 记录日志到数据库
            sysLogService.save(requestLog);
            SysLogUtils.log.info("保存日志成功!");
        } catch (Exception e) {
            SysLogUtils.log.error("保存日志失败: {}", e);
        }
    }

}
