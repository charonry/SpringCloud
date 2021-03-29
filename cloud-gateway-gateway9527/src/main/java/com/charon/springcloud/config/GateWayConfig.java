package com.charon.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2020-12-10 23:27
 **/
@Configuration
public class GateWayConfig {


    /**
     * 配置一个id为path_route_charon路由规则，
     * 当访问http://localhost:9527/guonei是自动跳转到http://news.baidu.com/guonei
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_charon",r ->
            r.path("/guonei").uri("http://news.baidu.com/guonei")
        ).build();
        routes.route("path_route_charon2",r ->
                r.path("/guoji").uri("http://news.baidu.com/guoji")
        ).build();
        return routes.build();
    }
}
