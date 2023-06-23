package com.yxw.managesystem.mbg;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class MbgUtil {

    private final static String url = "jdbc:mysql://116.62.242.203:3306/manage_system?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";

    private final static String username = "root";

    private final static String password = "lcy712YYD*";

    private final static String creator = "yyd";


    //需修改为自己的项目路径
    private final static String projectPath = "/home/stardust/Desktop/school-timetabling/ManageSystem";

    private final static String packagePath = "com.yxw.managesystem";

    public static boolean mbg(String... tables){
        try {
            FastAutoGenerator.create(new DataSourceConfig.Builder(url,username,password))
                    //bug：3.5.3版本所有tinyint都被转成Byte, fileOverride()失效
                    .globalConfig(builder -> {
                        builder.author(creator) // 设置作者
                                .fileOverride() // 覆盖已生成文件
                                .enableSwagger() // 开启 swagger 模式
                                .outputDir(projectPath + "//src//main//java"); // 指定输出目录
                    })
                    .packageConfig(builder -> {
                        builder.parent(packagePath) // 设置父包名
                                .pathInfo(Collections.singletonMap(OutputFile.mapperXml, projectPath + "//src//main//resources//mapper")); // 设置mapperXml生成路径
                    })
                    .strategyConfig(builder -> {
                        builder.addInclude(tables) // 设置需要生成的表名
//                            .addTablePrefix("syste") // 设置过滤表前缀
                            .mapperBuilder().           // 实体类名为表名去掉相应前缀并转为驼峰
                                enableMapperAnnotation()
                            .entityBuilder()
                                .enableLombok()
                                .enableChainModel()
                                .controllerBuilder()
                                .enableRestStyle();


                    })
                    .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                    .execute();
        }catch (Exception e){
            System.out.println("代码生成失败");
            System.out.println(e);
            return false;
        }
        return true;
    }
}

