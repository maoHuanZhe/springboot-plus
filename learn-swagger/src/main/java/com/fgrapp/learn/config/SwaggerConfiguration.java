package com.fgrapp.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfiguration
 *
 * @author fan guang rui
 * @date 2020年12月07日 18:56
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fgrapp.learn"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("账单项目接口文档")
                //简介
                .description("账单项目接口文档-简介")
                //服务Url
                .termsOfServiceUrl("http://localhost:8000/")
                //作者
                .contact(new Contact("fanguangrui", "http://localhost:8000", "898365387@qq.com"))
                //开源协议名称
                .license("MIT")
                //开源协议地址
                .licenseUrl("www.fgrapp.com")
                //版本
                .version("1.0")
                .build();
    }
}
