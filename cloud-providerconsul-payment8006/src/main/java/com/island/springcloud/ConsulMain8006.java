package com.island.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author island
 * @version 1.0 2021/4/18 20:15
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulMain8006 {

    public static void main(String[] args) {
        SpringApplication.run(ConsulMain8006.class,args);
    }
}
