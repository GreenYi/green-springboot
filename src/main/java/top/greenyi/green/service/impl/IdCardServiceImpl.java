package top.greenyi.green.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.greenyi.green.common.api.IdCardApi;
import top.greenyi.green.bean.IdCard;
import top.greenyi.green.service.IdCardService;

import java.util.Map;

/**
 * @author Green
 */
@Service
public class IdCardServiceImpl implements IdCardService {
    @Autowired
    private IdCardApi idCardApi;
    @Override
    public IdCard getIdCard(Map<String, String> map) {
        IdCard idCard = null;
        String cardNo = map.get("cardNo");
        String name = map.get("name");
        Map<String, Map<String, String>> idCardInfo = idCardApi.getIdCardInfo(cardNo, name);
        if (!idCardInfo.isEmpty()) {
            idCard = new IdCard();
            Map<String, String> resp = idCardInfo.get("resp");
            Map<String, String> data = idCardInfo.get("data");
            idCard.setDesc(resp.get("desc"));
            idCard.setCode(resp.get("code"));
            idCard.setBirthday(data.get("birthday"));
            idCard.setSex(data.get("sex"));
            idCard.setAddress(data.get("address"));
        }
        return idCard;

    }
}
