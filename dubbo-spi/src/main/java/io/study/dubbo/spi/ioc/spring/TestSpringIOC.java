package io.study.dubbo.spi.ioc.spring;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.config.spring.extension.SpringExtensionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringIOC {
    public static void main(String[] args) {
        // 1. 创建 spring 容器 + 加载 Bean 到该容器中
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring.xml"});
        // 2. 将 spring 容器添加到 dubbo 的 SpringExtensionFactory 工厂中
        SpringExtensionFactory.addApplicationContext(context);

        ExtensionLoader<Log> loader = ExtensionLoader.getExtensionLoader(Log.class);
        System.out.println("======================= 根据指定名称获取具体的 SPI 实现类（测试 spring ioc） =======================");
        // 3. 测试 dubbo spring ioc
        Log logback = loader.getExtension("logback");

        logback.execute();
    }
}
