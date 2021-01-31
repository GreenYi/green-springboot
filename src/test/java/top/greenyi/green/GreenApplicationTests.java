package top.greenyi.green;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.greenyi.green.common.api.WeatherApi;
import top.greenyi.green.bean.Dept;

@SpringBootTest
class GreenApplicationTests {

    @Test
    public void contextLoads() {
        Dept dept = new Dept();
        JSONArray json = new JSONArray();
        json.add("1");
        json.add("deptName");
        json.add("deptLoc");
        System.out.println(json);
        //Dept javaBean = JSON.parseObject("aa", new TypeReference<Dept>() {});
//        System.out.println(javaBean);
    }

    public static void main(String[] args) {
        String str = "{'Dept':[{'id':'1','deptName':'deptNameTest','deptLoc':'deptLocTest'}]}";
        JSONObject jsonObject = JSON.parseObject(str);
        System.out.println("jsonObject:" + jsonObject);
        JSONArray objects = (JSONArray) jsonObject.get("Dept");
        JSONObject  o = (JSONObject) objects.get(0);
        Dept javaBean = JSON.parseObject(o.toString(), new TypeReference<Dept>() {});
        System.out.println(javaBean);
    }

    @Test
    public void testWeather(){
        WeatherApi api = new WeatherApi();
        String weather = api.getWeather();
        System.out.println(weather);
    }

    @Test
    public int test2(String a) {
        String b = a + "1";
        return 4;
    }

    @Test
    public void test3(){
        int s = test2("4");
        System.out.println(s);
    }

}
