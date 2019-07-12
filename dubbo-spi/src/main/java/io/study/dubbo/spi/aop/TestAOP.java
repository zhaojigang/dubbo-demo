package io.study.dubbo.spi.aop;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

public class TestAOP {
    public static void main(String[] args) {
        ExtensionLoader<Log> loader = ExtensionLoader.getExtensionLoader(Log.class);

        System.out.println("======================= 根据指定名称获取具体的 SPI 实现类（测试 wrapper） =======================");
        Log logback = loader.getExtension("logback");
        /**
         * 输出
         * LogWrapper2 before
         * LogWrapper1 before
         * this is logback!
         * LogWrapper1 after
         * LogWrapper2 after
         */
        logback.execute();
    }
}
