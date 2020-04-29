package com.kingmao.dynamic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kingmao.dynamic.*.dao")
public class SpringbootDynamicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDynamicApplication.class, args);
    }

}
