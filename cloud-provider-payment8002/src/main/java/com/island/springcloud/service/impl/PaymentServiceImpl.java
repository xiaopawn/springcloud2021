package com.island.springcloud.service.impl;

import com.island.springcloud.entities.Payment;
import org.springframework.stereotype.Service;
import com.island.springcloud.dao.PaymentDao;
import com.island.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author island
 * @version 1.0 2021/4/13 15:49
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
