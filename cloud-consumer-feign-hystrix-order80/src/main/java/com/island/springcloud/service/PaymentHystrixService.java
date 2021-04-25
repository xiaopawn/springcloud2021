package com.island.springcloud.service;

import com.island.springcloud.service.fallback.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author island
 * @version 1.0 2021/4/21 20:39
 */
@Component
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVER",fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {


    @GetMapping("/payment/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Long id);


    @GetMapping("/payment/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Long id);
}
