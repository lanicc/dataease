package io.dataease.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

import static io.dataease.commons.constants.StaticResourceConstants.*;
import static io.dataease.commons.utils.StaticResourceUtils.ensureBoth;

/**
 * Author: wangjiahao
 * Date: 2022/4/24
 * Description:
 */
@Configuration
public class DeMvcConfig implements WebMvcConfigurer {
    /**
     * Configuring static resource path
     *
     * @param registry registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String workDir = Paths.get(WORK_DIR).toAbsolutePath().toString() + FILE_SEPARATOR;
        String uploadUrlPattern = ensureBoth(URL_SEPARATOR + UPLOAD_URL_PREFIX, URL_SEPARATOR) + "**";
        registry.addResourceHandler(uploadUrlPattern)
                .addResourceLocations("file:" + workDir);

    }
}
