package top.greenyi.green.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import top.greenyi.green.base.BaseBean;

/**
 * @author Green
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class IdCard extends BaseBean {
    private String cardNo;
    private String name;
    private String desc;
    private String code;
    private String birthday;
    private String sex;
    private String address;
}
