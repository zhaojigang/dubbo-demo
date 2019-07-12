package io.study.dubbo.spi.adaptive.auto;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

public class TestAdaptiveAuto {
    public static void main(String[] args) {
        ExtensionLoader<Log> loader = ExtensionLoader.getExtensionLoader(Log.class);

        System.out.println("======================= 获取 SPI 适配类（自动生成适配类） =======================");
        Log adaptiveExtension = loader.getAdaptiveExtension();
        URL url = new URL("dubbo", "10.211.55.6", 8080);
        adaptiveExtension.execute(url);
    }
}
