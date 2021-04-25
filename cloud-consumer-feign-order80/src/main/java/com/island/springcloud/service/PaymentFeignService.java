package com.island.springcloud.service;

import com.island.springcloud.entities.CommonResult;
import com.island.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author island
 * @version 1.0 2021/4/20 20:45
 */
@Component
@FeignClient(name = "CLOUD-PAYMENT-SERVER")
public interface PaymentFeignService {

    @GetMapping("/payment/getPaymentById/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);



    @GetMapping(value = "/payment/feign/timeout")
    String feignTimeout();
}
