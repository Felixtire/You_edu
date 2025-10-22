package com.mvpyouedu.YouEdu_api.infra;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigurationFileUpload  implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Qualquer requisição que começar com /uploads/ vai buscar os arquivos locais
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:///home/dev/uploads/");
    }
}
