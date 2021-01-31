package top.greenyi.green.common.api;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 暂时没有使用到此API
 * @author Green
 */
@Component
public class WeatherApi {
    @Value("${weather.key}")
    private String weatherKey;

    public String getWeather(String... args){
        //参数字符串，如果拼接在请求链接之后，需要对中文进行 URLEncode   字符集 UTF-8
        String param = "key=" + weatherKey + "&location=北京";
        StringBuilder sb = new StringBuilder();
        InputStream is = null;
        BufferedReader br = null;
        PrintWriter out = null;
        try {
            //接口地址
            String url = "https://free-api.heweather.net/s6/weather";
            URL uri = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
            connection.setRequestMethod("POST");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(10000);
            connection.setRequestProperty("accept", "*/*");
            //发送参数
            connection.setDoOutput(true);
            out = new PrintWriter(connection.getOutputStream());
            out.print(param);
            out.flush();
            //接收结果
            is = connection.getInputStream();
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line;
            //缓冲逐行读取
            while ( ( line = br.readLine() ) != null ) {
                sb.append(line);
            }
            System.out.println("Result:" + sb.toString());
        } catch ( Exception ignored ) {
            ignored.printStackTrace();
        } finally {
            //关闭流
            try {
                if (is!=null) {
                    is.close();
                }
                if (br!=null) {
                    br.close();
                }
                if (out!=null) {
                    out.close();
                }
            } catch ( Exception ignored ) {}
        }
        return sb.toString();
    }
}
