package io.study.dubbo.spi.protocoltest;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Protocol;

public class TestExtension {
    public static void main(String[] args) {
        ExtensionLoader<Protocol> loader = ExtensionLoader.getExtensionLoader(Protocol.class);
        testBasic(loader);
    }

    /**
     * 测试基础功能
     * @param loader
     */
    private static void testBasic(ExtensionLoader<Protocol> loader){
        Protocol dubboProtocol = loader.getExtension("dubbo");
    }

    /**
     * 测试 @Adaptive
     * @param loader
     */
    private static void testAdaptive(ExtensionLoader<Protocol> loader){
        Protocol adaptiveExtension = loader.getAdaptiveExtension();
    }
}