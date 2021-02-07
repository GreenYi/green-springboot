package top.greenyi.green.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import top.greenyi.green.base.BaseBean;

/**
 * @author Green
 */
@NoArgsConstructor
@Data
@ToString(callSuper = true)
public class IdCard extends BaseBean {
    /**
     * 姓名
     */
    private String name;
    /**
     * 身份证号
     */
    private String cardNo;
    /**
     * 描述
     */
    private String desc;
    /**
     * 代码
     */
    private String code;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 性别
     */
    private String sex;
    /**
     * 地址
     */
    private String address;
}
