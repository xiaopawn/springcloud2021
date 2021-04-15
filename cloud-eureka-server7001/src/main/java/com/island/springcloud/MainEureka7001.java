package com.island.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author island
 * @version 1.0 2021/4/14 21:05
 */
@SpringBootApplication
@EnableEurekaServer
public class MainEureka7001 {

    public static void main(String[] args) {
        SpringApplication.run(MainEureka7001.class, args);
    }
}
