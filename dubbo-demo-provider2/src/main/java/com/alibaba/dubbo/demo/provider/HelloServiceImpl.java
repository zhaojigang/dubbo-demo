package com.alibaba.dubbo.demo.provider;

import com.alibaba.dubbo.demo.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHi(String name) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("provider received: " + name);
        return "hi, " + name;
    }
}
