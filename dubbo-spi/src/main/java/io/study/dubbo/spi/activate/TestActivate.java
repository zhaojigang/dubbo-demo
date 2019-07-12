package io.study.dubbo.spi.activate;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

import java.util.List;

public class TestActivate {
    public static void main(String[] args) {
        ExtensionLoader<Log> loader = ExtensionLoader.getExtensionLoader(Log.class);
//        testGroup(loader);
        testValue(loader);
    }

    /**
     * 1. 测试 group
     */
    private static void testGroup(ExtensionLoader<Log> loader) {
        System.out.println("======================= 测试 group =======================");
        URL url = new URL("dubbo", "10.211.55.6", 8080);
        String group = "provider";
        String[] values = new String[]{};
        List<Log> activateExtension = loader.getActivateExtension(url, values, group);
        /**
         * 输出：
         * this is multi group!
         * this is single group!
         */
        activateExtension.forEach(Log::execute);
    }

    /**
     * 2. 测试 value
     */
    private static void testValue(ExtensionLoader<Log> loader) {
        System.out.println("======================= 测试 value =======================");
        URL url = new URL("dubbo", "10.211.55.6", 8080);
        String[] values = new String[]{"singleValue"};
        List<Log> activateExtension = loader.getActivateExtension(url, values, null);
        /**
         * 输出：
         */
        activateExtension.forEach(Log::execute);
    }
}
