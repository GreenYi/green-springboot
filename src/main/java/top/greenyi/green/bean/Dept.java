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
public class Dept extends BaseBean {
    private String deptName;
    private String deptLoc;
}
