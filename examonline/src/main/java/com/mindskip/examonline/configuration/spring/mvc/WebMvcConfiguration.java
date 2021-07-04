package com.mindskip.examonline.configuration.spring.mvc;

import com.mindskip.examonline.configuration.property.SystemConfig;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


/**
 * @author 孙林
 */

@Configuration
@AllArgsConstructor
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    private final SystemConfig systemConfig;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/student/index.html");
        registry.addRedirectViewController("/student", "/student/index.html");
        registry.addRedirectViewController("/admin", "/admin/index.html");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(31556926);
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowedHeaders("*");
        super.addCorsMappings(registry);
    }

}