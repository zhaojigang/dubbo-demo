package io.study.dubbo.spi.adaptive.auto;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

public class Log$Adaptive implements io.study.dubbo.spi.adaptive.auto.Log {
    @Override
    public void execute(com.alibaba.dubbo.common.URL arg0) {
        if (arg0 == null) {
            throw new IllegalArgumentException("url == null");
        }
        com.alibaba.dubbo.common.URL url = arg0;
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