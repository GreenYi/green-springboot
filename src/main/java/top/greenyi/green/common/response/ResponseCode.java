package top.greenyi.green.common.response;

/**
 * 返回状态码
 * @author Green
 */
public enum ResponseCode {

    /**
     * 成功返回的状态码
     */
    SUCCESS(200, "SUCCESS"),

    /**
     * 增加成功返回的状态码
     */
    SUCCESS_INSERT(200, "增加成功"),

    /**
     * 删除成功返回的状态码
     */
    SUCCESS_DELETE(200, "删除成功"),

    /**
     * 修改成功返回的状态码
     */
    SUCCESS_UPDATE(200, "修改成功"),

    /**
     * 查询成功返回的状态码
     */
    SUCCESS_GET(200, "查询成功"),

    /**
     * 资源不存在的状态码
     */
    RESOURCES_FORBIDDEN(403, "禁止访问"),

    /**
     * 资源不存在的状态码
     */
    RESOURCES_NOT_EXIST(404, "资源不存在"),

    /**
     * 所有无法识别的异常默认的返回状态码
     */
    SERVICE_ERROR(500, "服务器异常");

    /**
     * 状态码
     */
    private Integer status;

    /**
     * 返回信息
     */
    private String message;

    ResponseCode(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
