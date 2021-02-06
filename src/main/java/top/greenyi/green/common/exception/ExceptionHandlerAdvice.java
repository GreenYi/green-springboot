package top.greenyi.green.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.greenyi.green.base.BaseResponse;
import top.greenyi.green.common.response.ResponseCode;
import top.greenyi.green.common.response.ResponseResult;

/**
 * @author Green
 */
@ControllerAdvice(annotations = BaseResponse.class)
@ResponseBody
@Slf4j
public class ExceptionHandlerAdvice {
    /**
     * 处理未捕获的Exception
     * @param e 异常
     * @return 统一响应体
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult handleException(Exception e){
        log.error(e.getMessage(),e);
        return new ResponseResult(ResponseCode.SERVICE_ERROR.getStatus(),ResponseCode.SERVICE_ERROR.getMessage(),null);
    }

    /**
     * 处理未捕获的RuntimeException
     * @param e 运行时异常
     * @return 统一响应体
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseResult handleRuntimeException(RuntimeException e){
        log.error(e.getMessage(),e);
        return new ResponseResult(ResponseCode.SERVICE_ERROR.getStatus(),ResponseCode.SERVICE_ERROR.getMessage(),null);
    }

    /**
     * 处理业务异常BusinessException
     * @param e 业务异常
     * @return 统一响应体
     */
    @ExceptionHandler(value = {BusinessException.class})
    public ResponseResult handleBusinessException(BusinessException e){
        log.error(e.getMessage(),e);
        return new ResponseResult(e.getStatus(),e.getMessage(),null);
    }
}
