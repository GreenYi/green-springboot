package top.greenyi.green.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import top.greenyi.green.common.base.BaseBean;

/**
 * <p>
 * 
 * </p>
 *
 * @author Green
 * @since 2021-03-18
 */
@NoArgsConstructor
@Data
@ToString(callSuper = true)
public class SysLog extends BaseBean {

    /**
     * 公司ID
     */
    private Integer companyId;

    /**
     * 是否删除
     */
    private String isDeleted;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 操作人登录名
     */
    private String operatorLogin;

    /**
     * 模块名
     */
    private String moduleName;

    /**
     * 功能名称
     */
    private String functionName;

    /**
     * 请求类型
     */
    private String functionMethod;

    /**
     * URL
     */
    private String url;

    /**
     * 响应码
     */
    private String responseStatus;

    /**
     * 响应信息
     */
    private String responseMessage;

    /**
     * 响应数据
     */
    private String responseData;

    /**
     * 耗时
     */
    private Long useTime;

    /**
     * IP地址
     */
    private String ipAddress;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 备注
     */
    private String remark;

}
