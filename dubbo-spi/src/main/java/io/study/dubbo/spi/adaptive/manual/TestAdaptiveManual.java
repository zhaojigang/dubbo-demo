package io.study.dubbo.spi.adaptive.manual;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

public class TestAdaptiveManual {
    public static void main(String[] args) {
        ExtensionLoader<Log> loader = ExtensionLoader.getExtensionLoader(Log.class);

        System.out.println("======================= 获取 SPI 适配类（自己手写适配类） =======================");
        Log adaptiveExtension = loader.getAdaptiveExtension(); // AdaptiveLog 实例
        adaptiveExtension.execute("log4j"); // this is log4j! log4j
    }
}
