package top.greenyi.green.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 统一的公共响应体
 * @author Green
 */
@Data
@AllArgsConstructor
public class ResponseResult implements Serializable {
    /**
     * 返回状态码
     */
    private Integer status;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 数据
     */
    private Object data;

    public ResponseResult(ResponseCode responseCode, Object data){
        this.status = responseCode.getStatus();
        this.message = responseCode.getMessage();
        this.data = data;
    }
}
