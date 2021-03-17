package top.greenyi.green.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import top.greenyi.green.common.base.BaseBean;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Green
 * @since 2021-03-17
 */
@NoArgsConstructor
@Data
@ToString(callSuper = true)
public class SysUser extends BaseBean {

    private Integer companyId;

    private String isDeleted;

    private String isEnabled;

    private String name;

    private String loginName;

    private String password;

    private String sex;

    private String phone;

    private String email;

    private Date createTime;

    private Date updateTime;

}
