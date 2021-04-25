package com.island.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author island
 * @version 1.0 2021/4/24 22:39
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        // http://news.baidu.com/guonei
        // 用代码的方式实现路由转发
        routes.route("island",r -> r.path("/guonei").uri("http://news.baidu.com/"));
        routes.route("island2",r -> r.path("/guoji").uri("http://news.baidu.com/"));
        routes.route("island3",r -> r.path("/game").uri("http://news.baidu.com/"));
        return routes.build();
    }
}
