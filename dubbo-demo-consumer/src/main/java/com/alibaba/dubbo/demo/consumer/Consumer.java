package com.alibaba.dubbo.demo.consumer;

import com.alibaba.dubbo.demo.DemoService;
import com.alibaba.dubbo.demo.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/dubbo-demo-consumer.xml"});
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService"); // get remote service proxy
        HelloService helloService = (HelloService) context.getBean("helloService"); // get remote service proxy

//        while (true) {
            try {
//                Thread.sleep(1000);
                String hello = demoService.sayHello("world"); // call remote method
                String hi = helloService.sayHi("zipkin");
                System.out.println(hello + "=====" + hi); // get result
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
//        }
    }
}
