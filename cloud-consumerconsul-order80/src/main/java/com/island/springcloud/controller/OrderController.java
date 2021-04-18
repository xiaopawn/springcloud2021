package com.island.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author island
 * @version 1.0 2021/4/18 20:25
 */
@RestController
@RequestMapping("/order/consul")
public class OrderController {

    public static final String ZK_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/payment/consul")
    public String paymentInfo(){

        String result = restTemplate.getForObject(ZK_URL + "/payment/consul", String.class);
        return result;
    }
}
