package io.study.dubbo.spi.ioc.spi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

public class TestSPIIOC {
    public static void main(String[] args) {
        ExtensionLoader<Log> loader = ExtensionLoader.getExtensionLoader(Log.class);

        System.out.println("======================= 测试 SPI IOC =======================");
        Log logback = loader.getExtension("logback");
        logback.execute();

        System.out.println("======================= 测试禁用 SPI IOC =======================");
        Log log4j = loader.getExtension("log4j");
        log4j.execute();
    }
}
