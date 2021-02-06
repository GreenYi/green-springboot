package top.greenyi.green.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.greenyi.green.common.response.ResponseCode;

/**
 * 业务异常类，继承运行时异常，确保事务正常回滚
 * @author Green
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BusinessException extends RuntimeException{

    private int status;
    private String message;

    public BusinessException(ResponseCode responseCode) {
        this.status = responseCode.getStatus();
        this.message = responseCode.getMessage();
    }
}
