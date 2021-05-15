package cn.liuhao.market;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("cn.liuhao.market.dao")
@SpringBootApplication
public class WebMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebMarketApplication.class, args);
    }

}
