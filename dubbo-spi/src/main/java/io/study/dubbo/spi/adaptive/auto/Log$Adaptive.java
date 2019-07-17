package io.study.dubbo.spi.adaptive.auto;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

public class Log$Adaptive implements io.study.dubbo.spi.adaptive.auto.Log {
    @Override
    public void execute(com.alibaba.dubbo.common.URL arg0) {
        if (arg0 == null) {
            throw new IllegalArgumentException("url == null");
        }
        com.alibaba.dubbo.common.URL url = arg0;
        // 首先获取url中的xxx=ppp这个参数的值ppp，假设有，使用该值去获取key为ppp的 SPI 实现类；假设没有，再获取ooo=ppp，假设也没有，使用默认的logback去获取key为logback的SPI实现类
        String extName = url.getParameter("xxx", url.getParameter("ooo", "logback"));
        if (extName == null) {
            throw new IllegalStateException("Fail to get extension(io.study.dubbo.spi.adaptive.auto.Log) name from url(" + url.toString() + ") use keys([xxx, ooo])");
        }
        io.study.dubbo.spi.adaptive.auto.Log extension = (io.study.dubbo.spi.adaptive.auto.Log) ExtensionLoader.getExtensionLoader(io.study.dubbo.spi.adaptive.auto.Log.class).getExtension(extName);
        extension.execute(arg0);
    }

    @Override
    public void test() {
        throw new UnsupportedOperationException("method public abstract void io.study.dubbo.spi.adaptive.auto.Log.test() of interface io.study.dubbo.spi.adaptive.auto.Log is not adaptive method!");
    }
}