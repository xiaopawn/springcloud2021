package com.island.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author island
 * @version 1.0 2021/4/13 17:25
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PAYMENT-SERVER",configuration = MySelfRule.class)
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }

}
