package com.hyl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 韩宇龙
 * @create 2020-03-15 11:05
 *  swagger2插件
 */
@Configuration //springboot 配置类注解
@EnableSwagger2//启用Swagger2注解
public class Swagger2Config implements WebMvcConfigurer {
    //配置swagger 的docket的bean实例
    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                /**
                 * RequestHandlerSelectors  配置扫描接口的方式
                 * basePackage()  指定扫描的包
                 * any()  扫描全部
                 * none()  不扫描
                 * withClassAnnotation() 扫描类上的注解，参数是一个注解的反射对象
                 * withMethodAnnotation() 扫描方法上的注解
                * */
                .apis(RequestHandlerSelectors.basePackage("com.hyl.controller"))
                 /**paths() 过滤*/
                .paths(PathSelectors.any())
                .build();
    }
    /**
     * Spring Boot自动配置本身不会自动把
     * swagger-ui.html这个路径映射到对应的目录META-INF/resources/ 下面。
     * 我们加上这个映射即可*/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("网站-酒店管理API文档")
                .description("Swagger2构建RESTful APIs")
                .termsOfServiceUrl("http://www.baidu.com/")
                .version("1.0")
                .build();
    }
}

