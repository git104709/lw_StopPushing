package com.test.lw_StopPushing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.test.lw_StopPushing.mapper")
public class lw_StopPushingApplication {
    public static void main(String[] args) {
        SpringApplication.run(lw_StopPushingApplication.class,args);

    }

}
