package top.greenyi.green.service;

import top.greenyi.green.base.BaseService;
import top.greenyi.green.bean.IdCard;

/**
 * @author Green
 */
public interface IdCardService extends BaseService<IdCard> {

    /**
     * 获取身份证
     * @param cardNo
     * @param name
     * @return
     */
    IdCard getIdCard(String cardNo, String name);
}
