package com.island.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author island
 * @version 1.0 2021/4/15 20:18
 */
@SpringBootApplication
@EnableEurekaServer
public class MainEureka7002 {

    public static void main(String[] args) {
        SpringApplication.run(MainEureka7002.class, args);
    }

}
