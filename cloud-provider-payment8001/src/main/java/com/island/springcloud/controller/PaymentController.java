package com.island.springcloud.controller;

import com.island.springcloud.entities.CommonResult;
import com.island.springcloud.entities.Payment;
import com.island.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author island
 * @version 1.0 2021/4/13 15:51
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);

        log.info("插入结果" + result);

        if (result > 0){
            return new CommonResult<>(200,"插入数据库成功",result);
        }else {
            return new CommonResult<>(444,"插入数据库失败",null);
        }
    }

    @GetMapping("/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){

        Payment payment = paymentService.getPaymentById(id);

        if (Objects.nonNull(payment)){
            return new CommonResult<>(200,"查询成功",payment);
        }else {
            return new CommonResult<>(444,"没有对应记录 查询id:" + id,null);
        }
    }
}
