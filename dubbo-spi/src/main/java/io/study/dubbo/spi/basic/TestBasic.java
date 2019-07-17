package io.study.dubbo.spi.basic;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

import java.util.Set;

public class TestBasic {
    public static void main(String[] args) {
        ExtensionLoader<Log> loader = ExtensionLoader.getExtensionLoader(Log.class);

        System.out.println("======================= 根据指定名称获取具体的 SPI 实现类 =======================");
        // 1. 指定名称获取具体 SPI 实现类
        Log logback = loader.getExtension("logback");
        logback.execute(); // this is logback!
        Log log4j = loader.getExtension("log4j");
        log4j.execute(); // this is log4j!

        System.out.println("======================= 获取默认实现类 =======================");
        // 2. 获取默认实现类 @SPI("logback") 中的 logback 就指定了默认的 SPI 实现类的 key
        Log defaultExtension = loader.getDefaultExtension();
        defaultExtension.execute(); // this is logback!
        System.out.println(loader.getDefaultExtensionName()); // logback

        System.out.println("======================= 获取支持哪些 SPI 实现类 =======================");
        // 3. 获取支持哪些 SPI 实现类
        Set<String> supportedExtensions = loader.getSupportedExtensions();
        supportedExtensions.forEach(System.out::println); // log4j \n logback

        System.out.println("======================= 获取已经加载了哪些 SPI 实现类 =======================");
        // 4. 获取已经加载了哪些 SPI 实现类
        Set<String> loadedExtensions = loader.getLoadedExtensions();
        loadedExtensions.forEach(System.out::println); // log4j \n logback

        System.out.println("======================= 根据 SPI 实现类实例或者实现类的 Class 信息获取其 key =======================");
        // 5. 根据 SPI 实现类实例或者实现类的 Class 信息获取其 key
        System.out.println(loader.getExtensionName(logback)); // logback
        System.out.println(loader.getExtensionName(Logback.class)); // logback

        System.out.println("======================= 判断是否具有指定 key 的 SPI 实现类 =======================");
        // 6. 判断是否具有指定 key 的 SPI 实现类
        System.out.println(loader.hasExtension("logback")); // true
        System.out.println(loader.hasExtension("log4j2"));  // false
    }
}
