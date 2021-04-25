package com.island.springcloud.controller;

import com.island.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author island
 * @version 1.0 2021/4/21 20:41
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/cousumer/payment/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Long id){

        String result = paymentHystrixService.paymentInfo_OK(id);
        log.info("***********result" + result);
        return result;
    }


    @GetMapping("/cousumer/payment/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Long id){
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        log.info("***********result" + result);
        return result;
    }

    @GetMapping("/cousumer/payment/timeout2/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler"/*指定善后方法名*/,commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_TimeOut2(Long id)
    {
        int i = 10/0;
//        String result = paymentHystrixService.paymentInfo_TimeOut(id);
//        return result;
        return null;
    }

    public String paymentInfo_TimeOutHandler(Long id)
    {
        return "线程池:  "+Thread.currentThread().getName()+"  80系统繁忙或者运行报错，请稍后再试,id:  "+id+"\t"+"o(╥﹏╥)o";
    }

    // 下面是全局fallback方法
    public String payment_Global_FallbackMethod()
    {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}

