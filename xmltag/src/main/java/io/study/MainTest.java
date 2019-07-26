package io.study;

import io.study.xmltag.RpcConfig;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 */
public class MainTest {
    public static void main(String[] args) {
        // 1. 加载配置文件 rpc.xml
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test/rpc.xml");
        // 2. 根据 type 获取 bean；也可以根据 name 获取 bean
        RpcConfig rpc = context.getBean(RpcConfig.class);
        // 3. 使用 bean
        System.out.println(rpc.getId() + " - " + rpc.getTimeout());
    }
}
