package com.island.springcloud.controller;

import com.island.springcloud.entities.CommonResult;
import com.island.springcloud.entities.Payment;
import com.island.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author island
 * @version 1.0 2021/4/20 20:49
 */
@RestController
public class PaymentController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String feignTimeout(){
        return paymentFeignService.feignTimeout();
    }

}
