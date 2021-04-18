package com.island.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author island
 * @version 1.0 2021/4/18 1:13
 */
@RestController
@RequestMapping("/order/zk")
public class OrderZKController {

    public static final String ZK_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/payment/zk")
    public String paymentInfo(){

        String result = restTemplate.getForObject(ZK_URL + "/payment/zk", String.class);
        return result;
    }
}
