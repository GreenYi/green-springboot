package top.greenyi.green;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Green
 */

@MapperScan("top.greenyi.green.mapper")
@SpringBootApplication
public class GreenApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreenApplication.class, args);
    }

}
