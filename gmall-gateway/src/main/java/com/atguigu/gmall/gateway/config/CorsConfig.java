package com.atguigu.gmall.gateway.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @author : SongMc
 * @date : 2021/1/19 8:40
 * className : CorsConfig
 * package: com.atguigu.gmall.gateway.config
 * version : 1.0
 * Description
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {

        // 初始化CORS配置对象
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 允许跨域方法的请求域名,不要写*，*代表所有域名。但不能携带cookie
        corsConfiguration.addAllowedOrigin("http://manager.gmall.com");
        corsConfiguration.addAllowedOrigin("http://api.gmall.com");
        corsConfiguration.addAllowedOrigin("http://localhost:1000");
        corsConfiguration.addAllowedOrigin("http://gmall.com");
        corsConfiguration.addAllowedOrigin("http://www.gmall.com");
        // 允许的请求方法 *代表所有方法
        corsConfiguration.addAllowedMethod("*");
        // 允许跨域访问携带的头信息  *代表所有头信息
        corsConfiguration.addAllowedHeader("*");
        // 是否允许携带Cookie信息
        corsConfiguration.setAllowCredentials(true);

        // 添加映射路径，我们拦截一切请求  跨域配置对象
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        // 拦截所有域名
        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsWebFilter(corsConfigurationSource);
    }
}