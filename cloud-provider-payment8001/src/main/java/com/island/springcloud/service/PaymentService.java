package com.island.springcloud.service;

import com.island.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author island
 * @version 1.0 2021/4/13
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
