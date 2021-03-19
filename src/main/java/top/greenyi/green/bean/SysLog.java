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

    private Integer companyId;

    private String isDeleted;

    private String operator;

    private String operatorLogin;

    private String moduleName;

    private String functionName;

    private String functionMethod;

    private String url;

    private String responseStatus;

    private String responseMessage;

    private String responseData;

    private Long useTime;

    private String ipAddress;

    private String roleName;

    private String remark;

}
