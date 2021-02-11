package com.morphy.musicserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.morphy.musicserver.dao"})
public class MusicserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicserverApplication.class, args);
    }

}
