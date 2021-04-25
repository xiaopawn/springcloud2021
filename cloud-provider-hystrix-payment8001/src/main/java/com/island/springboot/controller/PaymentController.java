package com.island.springboot.controller;

import com.island.springboot.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author island
 * @version 1.0 2021/4/21 19:56
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Long id){
        String result = paymentService.paymentInfo_OK(id);
        log.info("***********result" + result);
        return result;
    }

    @GetMapping("/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Long id){
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("***********result" + result);
        return result;
    }

    // 服务熔断
    @GetMapping("/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Long id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("***********result" + result);
        return result;
    }

}
