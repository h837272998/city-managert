package com.hjh.h5citymanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hjh.h5citymanage.mapper")
public class H5CitymanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(H5CitymanageApplication.class, args);
    }

}
