package com.yxw.managesystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Field;

@SpringBootApplication
@MapperScan("com.yxw.managesystem.mapper")
public class ManageSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManageSystemApplication.class, args);
        System.out.println("\n==============================================\n");
        System.out.println("文档地址: " + "http://localhost:8888/doc.html");
        System.out.println("\n==============================================\n");
    }

}
