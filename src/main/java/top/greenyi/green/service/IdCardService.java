package top.greenyi.green.service;

import top.greenyi.green.bean.IdCard;

import java.util.Map;

/**
 * @author Green
 */
public interface IdCardService {

    /**
     * 获取身份证
     * @param map
     * @return
     */
    IdCard getIdCard(Map<String, String> map);
}
