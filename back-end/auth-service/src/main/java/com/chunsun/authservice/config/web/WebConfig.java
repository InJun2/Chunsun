package com.chunsun.authservice.config.web;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    @Bean
    @ConditionalOnMissingBean(UrlBasedCorsConfigurationSource.class)
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
        var corsConfig = new CorsConfiguration();

        corsConfig.addAllowedOriginPattern(CorsConfiguration.ALL);
        corsConfig.addAllowedHeader(CorsConfiguration.ALL);
        corsConfig.addAllowedMethod(CorsConfiguration.ALL);

        corsConfig.setAllowCredentials(true);
        corsConfig.setMaxAge(3600L);

        var corsConfigSource = new UrlBasedCorsConfigurationSource();
        corsConfigSource.registerCorsConfiguration("/**", corsConfig);
        return corsConfigSource;
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor()
//                .addPathPatterns("/**");
//    }
}