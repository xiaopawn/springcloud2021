package com.island.springcloud.service.fallback;

import com.island.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author island
 * @version 1.0 2021/4/22 19:50
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Long id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Long id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
    }
}
