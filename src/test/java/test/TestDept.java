package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONObject;

import cn.com.green.bean.Dept;
import cn.com.green.dao.DeptDao;
import cn.com.green.service.IDeptService;
import cn.com.green.util.common.HttpUtils;

public class TestDept {
	@Test
	public void testInsertDept() {
		//1.获取spring容器
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		//2.获取bean对象
		DeptDao deptdao = ac.getBean("deptDao",DeptDao.class);
		//调用方法
		Dept dept = new Dept();
		dept.setDeptName("第一开发部");
		dept.setDeptLoc("中关村");
		deptdao.insertDept(dept);
		//关闭容器
		ac.close();
	}
	@Test
	public void testAddDept() {
		//1.获取spring容器
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-service.xml","application-dao.xml");
		//2.获取bean对象
		IDeptService ds = ac.getBean("deptService",IDeptService.class);
		Dept dept = new Dept();
		dept.setDeptName("第一研发部");
		dept.setDeptLoc("北京");
		ds.addDept(dept);
		ac.close();
	}
	@Test
	public void testShowDept() {
		//1.获取spring容器
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-service.xml","application-dao.xml");
		//2.获取bean对象
		DeptDao deptdao = ac.getBean("deptDao",DeptDao.class);
		List<Dept> list = deptdao.selectAll();
		for(Dept d : list) {
			System.out.println(d);
		}
		ac.close();
	}
	@Test
	public void testGetAll() {
		//1.获取spring容器对象
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-service.xml","application-dao.xml");
		//2.获取bean对象
		IDeptService ds = ac.getBean("deptService",IDeptService.class);
		//3.调用方法
		System.out.println(ds.getAll());
		ac.close();
	}
	@Test
	public void testDeleteById() {
		//1.获取spring容器
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-service.xml","application-dao.xml");
		//2.获取bean对象
		DeptDao deptdao = ac.getBean("deptDao",DeptDao.class);
		deptdao.deleteById(5);
		ac.close();
	}
	@Test
	public void testRemoveDept() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-service.xml","application-dao.xml");
		IDeptService ds = ac.getBean("deptService",IDeptService.class);
		ds.removeDept(4);
		ac.close();
	}
	
	@Test
	public void testApiPoiCheck() {
	    String host = "http://ali-poi.showapi.com";
	    String path = "/gps-poi";
	    String method = "GET";
	    String appcode = "6e164e7200b0418594a31cd5b2f48741";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("location", "39.915,116.404");
	    querys.put("q", "银行");
	    querys.put("radius", "radius");


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
	    	System.out.println(response.toString());
	    	//获取response的body
	    	System.out.println(EntityUtils.toString(response.getEntity()));
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	@Test
	public void testApiIdCard() {
	    String host = "https://idcard.market.alicloudapi.com";
	    String path = "/lianzhuo/idcard";
	    String method = "GET";
	    String appcode = "6e164e7200b0418594a31cd5b2f48741";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("cardno", "370703198111300338");
	    querys.put("name", "郭德昌");


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
	    	System.out.println(response.toString());
	    	//获取response的body
	    	System.out.println(EntityUtils.toString(response.getEntity()));
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	public static void main(String[] args) {
		System.out.println("Test commit");
		  String str = "{\"resp\": {\"code\": 0,\"desc\": \"匹配\"},\"data\": {\"sex\": \"男\",\"address\": \"广东省清远市清新县\",\"birthday\": \"1989-05-25\"}}";
		  JSONObject parseObject =JSONObject.parseObject(str);
		  Map<String, Map<String,String>> map = new HashMap<String, Map<String,String>>();
		  for (String key : parseObject.keySet()) {
			  Map<String,String> mapStr = new HashMap<String, String>();
			  JSONObject parseObject2 = JSONObject.parseObject(parseObject.get(key).toString());
			  for (String key2 : parseObject2.keySet()) {
				  mapStr.put(key2, parseObject2.get(key2).toString());
			  }
			  map.put(key, mapStr);
		  }
		  System.out.println(map);
	}
}
