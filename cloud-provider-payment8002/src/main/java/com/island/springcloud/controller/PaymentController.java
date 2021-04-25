package com.island.springcloud.controller;

import com.island.springcloud.entities.CommonResult;
import com.island.springcloud.entities.Payment;
import com.island.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
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

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);

        log.info("插入结果" + result);

        if (result > 0){
            return new CommonResult<>(200,"插入数据库成功 serverPort:" + serverPort,result);
        }else {
            return new CommonResult<>(444,"插入数据库失败",null);
        }
    }

    @GetMapping("/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){

        Payment payment = paymentService.getPaymentById(id);

        if (Objects.nonNull(payment)){
            return new CommonResult<>(200,"查询成功 serverPort" + serverPort,payment);
        }else {
            return new CommonResult<>(444,"没有对应记录 查询id:" + id,null);
        }
    }

    @GetMapping("discovery")
    public Object discovery(){

        List<String> services = discoveryClient.getServices();
        for (String service : services) {

            log.info("service:" + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVER");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return discoveryClient;
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB() {
        return serverPort;//返回服务接口
    }
}
