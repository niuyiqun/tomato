package com.sdu.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author niu
 * @Description:
 * @date 2021/9/2416:44
 */


@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {
    /**上传地址*/
    @Value("${file.upload.path}")
    private String filePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/image/**").addResourceLocations("file:/" + filePath);
    }
}


