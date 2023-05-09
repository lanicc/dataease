package io.dataease.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${geo.custom.rootpath:/opt/dataease/data/custom/}")
    private String geoPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/geo/**").addResourceLocations("file:" + geoPath);

//        String workDir = Paths.get(ensureSuffix(WORK_DIR, FILE_SEPARATOR)).toAbsolutePath().toString();
//        String uploadUrlPattern = ensureBoth(URL_SEPARATOR + UPLOAD_URL_PREFIX, URL_SEPARATOR) + "**";
//        registry.addResourceHandler(uploadUrlPattern)
//                .addResourceLocations("file:" + "/Users/lan/IdeaProjects/github/dataease/data/static-resource/");
    }
}
