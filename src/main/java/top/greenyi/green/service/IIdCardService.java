package top.greenyi.green.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.greenyi.green.bean.IdCard;

/**
 * @author Green
 */
public interface IIdCardService extends IService<IdCard> {

    /**
     * 获取身份证
     * @param cardNo
     * @param name
     * @return
     */
    IdCard getIdCard(String cardNo, String name);
}
