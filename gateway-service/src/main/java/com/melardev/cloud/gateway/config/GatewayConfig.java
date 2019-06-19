package com.melardev.cloud.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api/todos/**")
                        .filters(f -> f.rewritePath("/api/todos/?(?<path>.*)", "/todos/${path}")
                                .hystrix(c -> c.setName("hystrix")
                                        .setFallbackUri("forward:/fallback")))
                        .uri("lb://todo-service")
                        .id("todo-service"))

                .route(r -> r.path("/proxy/todos/**")
                        .filters(f -> f.rewritePath("/proxy/todos/?(?<path>.*)", "/todos/${path}")
                                .hystrix(c -> c.setName("hystrix").setFallbackUri("forward:/fallback/proxy")))
                        .uri("lb://todo-proxy-service")
                        .id("todo-proxy-super-micro-service"))
                .build();
    }
}
