package com.island.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author island
 * @version 1.0 2021/4/20 20:46
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients // 开启fegin调用
public class OrderFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class,args);
    }
}
