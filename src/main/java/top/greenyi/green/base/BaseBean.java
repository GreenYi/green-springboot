package top.greenyi.green.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author Green
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BaseBean {
    private Long id;
    private Date createTime;
    private Date updateTime;
}
