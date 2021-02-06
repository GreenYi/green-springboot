package top.greenyi.green.common.api;

import cn.hutool.core.map.MapUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import top.greenyi.green.bean.IdCard;
import top.greenyi.green.common.utils.HttpUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Green
 */
@Slf4j
@Component
public class IdCardApi {

	@Value("${idCard.appCode}")
	private String appCode;
	
	/**
	 * 阿里云的接口
	 * @param cardNo 身份证号
	 * @param name 姓名
	 * @return
	 */
	private String getIdCardApi(String cardNo, String name) {
		String result = null;
	    String host = "https://idcard.market.alicloudapi.com";
	    String path = "/lianzhuo/idcard";
	    String method = "GET";
	    Map<String, String> headers = new HashMap<>(0);
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appCode);
	    Map<String, String> querys = new HashMap<>(0);
	    querys.put("cardno", cardNo);
	    querys.put("name",  name);
	    try {
	    	/**
	    	* 重要提示如下:
	    	* HttpUtils请从
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
	    	* 下载
	    	*
	    	* 相应的依赖请参照
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
	    	*/
	    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
	    	log.info("response: {}", response.toString());
	    	//获取response的body
	    	if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
	    		result = EntityUtils.toString(response.getEntity());
	    	}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return result;
	}
	
	/**
	 * String类型的JsonObject转Map
	 * @param str 阿里云接口返回的String
	 * @return
	 */
	private Map<String, Map<String,String>> convertJsonObject(String str) {
		Map<String, Map<String,String>> map = new HashMap<>(0);
		if (StringUtils.isNotEmpty(str)) {
			JSONObject parseObject = JSONObject.parseObject(str);
			for (String key : parseObject.keySet()) {
				Map<String,String> mapStr = new HashMap<>(0);
				JSONObject parseObject2 = JSONObject.parseObject(parseObject.get(key).toString());
				for (String key2 : parseObject2.keySet()) {
					mapStr.put(key2, parseObject2.get(key2).toString());
				}
				map.put(key, mapStr);
			}
		}
		return map;
	}

	/**
	 * map转IdCard
	 * @param map
	 * @return
	 */
	private IdCard convertMap(Map<String, Map<String,String>> map) {
		IdCard idCard = null;
		if (MapUtil.isNotEmpty(map)) {
			idCard = new IdCard();
			Map<String, String> resp = map.get("resp");
			Map<String, String> data = map.get("data");
			idCard.setDesc(resp.get("desc"));
			idCard.setCode(resp.get("code"));
			idCard.setBirthday(data.get("birthday"));
			idCard.setSex(data.get("sex"));
			idCard.setAddress(data.get("address"));
		}
		return idCard;
	}

	/**
	 * 身份认证
	 * @param cardNo 身份证号
	 * @param name 姓名
	 * @return map
	 */
	public IdCard getIdCard(String cardNo, String name) {
		String jsonObject = this.getIdCardApi(cardNo, name);
		Map<String, Map<String, String>> map = this.convertJsonObject(jsonObject);
		IdCard idCard = this.convertMap(map);
		return idCard;
	}

}
