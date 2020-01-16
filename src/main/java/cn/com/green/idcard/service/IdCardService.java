package cn.com.green.idcard.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.green.idcard.bean.IdCard;
import cn.com.green.util.api.IdCardApi;

@Service
public class IdCardService {
	@Resource
	private IdCardApi idCardApi;
	public IdCard getIdCardInfo(String cardno, String name) {
		IdCard idCard = null;
		Map<String, Map<String, String>> idCardInfo = idCardApi.getIdCardInfo(cardno, name);
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
