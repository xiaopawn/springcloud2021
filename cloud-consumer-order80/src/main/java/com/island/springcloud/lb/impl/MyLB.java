package com.island.springcloud.lb.impl;

import com.island.springcloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author island
 * @version 1.0 2021/4/19 20:29
 */
@Component
public class MyLB implements LoadBalancer {


    private final AtomicInteger atomicInteger = new AtomicInteger(0);


    // 负载均衡算法 当前请求次数 % 机器总数 = 实际调用服务器下标的位置
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }

    public final int getAndIncrement() {

        int next;
        int current;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*****第几次访问，次数next: " + next);
        return next;
    }
}
