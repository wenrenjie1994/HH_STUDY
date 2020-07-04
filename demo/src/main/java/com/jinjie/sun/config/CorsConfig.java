package com.jinjie.sun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * 跨域
 */
//@Configuration
public class CorsConfig {
//    @Bean
//    public CorsFilter corsFilter() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        // 开放的ip、端口、域名
//        corsConfiguration.addAllowedOrigin("*");
//        // 是否允许发送Cookie
//        corsConfiguration.setAllowCredentials(true);
//        // 允许的HTTP方法
//        corsConfiguration.addAllowedMethod("*");
//        // 允许携带的Header信息
//        corsConfiguration.addAllowedHeader("*");
//        // 暴露的头部信息
//        corsConfiguration.setExposedHeaders(Arrays.asList("Content-Range", "Authorization"));
//        corsConfiguration.setMaxAge(3600L);
//        // 添加映射路径，“/**”表示对所有的路径实行全局跨域访问权限的设置
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfiguration);
//        return new CorsFilter(source);
//    }
}
