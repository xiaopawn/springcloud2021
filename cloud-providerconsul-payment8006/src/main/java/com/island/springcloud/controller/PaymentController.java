package com.island.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author island
 * @version 1.0 2021/4/18 20:16
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    // 测试zookeeper作为注册中心
    @RequestMapping(value = "/consul")
    public String paymentConsul() {
        return "springCloud with consul: " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
