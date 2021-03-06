package com.island.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author island
 * @version 1.0 2021/4/13 17:34
 */
@Configuration
public class ApplicationContextConfig {

    // 开启负载均衡策略 要不然集群环境访问会报错
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
