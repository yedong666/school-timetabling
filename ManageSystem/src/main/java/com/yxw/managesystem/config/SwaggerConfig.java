package com.yxw.managesystem.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * Swagger2API文档的配置
 * 访问路径
 */
@Configuration
@EnableWebMvc
@EnableSwagger2WebMvc
public class SwaggerConfig {

    @Bean(value = "defaultApi")
    public Docket defaultApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("1.0版本")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.yxw.managesystem.controller"))
                //这里指定扫描有ApiOperation注解的类
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //所有路径
                .paths(PathSelectors.any())
                //不包含^/inner/.*的路径
                //.paths(input -> !input.matches("^/inner/.*"))
                .build();
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Manage System APIs")
                .description("系统接口文档")
                .version("1.0")
                .build();
    }
}