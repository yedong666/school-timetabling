package com.yxw.managesystem;

import jdk.internal.misc.Unsafe;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Field;

@SpringBootApplication
@MapperScan("com.yxw.managesystem.mapper")
public class ManageSystemApplication {

    public static void main(String[] args) {
        disableWarning();
        SpringApplication.run(ManageSystemApplication.class, args);
        System.out.println("\n==============================================\n");
        System.out.println("文档地址: " + "http://localhost:8888/doc.html");
        System.out.println("\n==============================================\n");
    }

    public static void disableWarning() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            Unsafe u = (Unsafe) theUnsafe.get(null);

            Class cls = Class.forName("jdk.internal.module.IllegalAccessLogger");
            Field logger = cls.getDeclaredField("logger");
            u.putObjectVolatile(cls, u.staticFieldOffset(logger), null);
        } catch (Exception e) {
            // ignore
        }
    }

}
