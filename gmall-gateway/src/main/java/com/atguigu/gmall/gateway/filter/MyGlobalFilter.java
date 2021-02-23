package com.atguigu.gmall.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author : SongMc
 * @date : 2021/2/22 20:55
 * className : MyGlobalFilter
 * package: com.atguigu.gmall.gateway.filter
 * version : 1.0
 * Description
 */
@Component
public class MyGlobalFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("这是全局过滤器，无差别的拦截所有经过网关的请求");
        // 放行
        return chain.filter(exchange);
    }
}
