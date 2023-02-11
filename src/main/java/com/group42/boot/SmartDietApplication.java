package com.group42.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication(scanBasePackages = {"com.group42.**"})
@MapperScan("com.group42.dao")
public class SmartDietApplication {

    public static void  main(String[] args) {
        SpringApplication.run(SmartDietApplication.class, args);
    }

}
