package com.mic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//扫描mybatis能用mapper所在的包
@MapperScan(basePackages = "com.mic.mapper")
// idworker 扫描所有包以及相关组件包
@ComponentScan(basePackages = {"com.mic", "org.n3r.idworker"})
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class);
    }
}
