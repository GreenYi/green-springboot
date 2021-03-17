package top.greenyi.green.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import top.greenyi.green.common.base.BaseBean;

/**
 * @author Green
 */
@NoArgsConstructor
@Data
@ToString(callSuper = true)
public class Dept extends BaseBean {
    /**
     * 部门
     */
    private String deptName;
    /**
     * 地址
     */
    private String deptLoc;
}
