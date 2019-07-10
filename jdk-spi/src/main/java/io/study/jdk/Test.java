package io.study.jdk;

import io.study.jdk.spi.Log;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        // 1. 获取 ServiceLoader
        ServiceLoader<Log> loader = ServiceLoader.load(Log.class);
        // 2. 获取迭代器
        Iterator<Log> iterator = loader.iterator();
        // 3. 迭代读取实现类 调用 hasNext 方法的时候会去加载配置文件进行解析
        while (iterator.hasNext()) {
            // 调用 next 方法的时候进行实例化并缓存
            Log log = iterator.next();
            // 4. 执行实现类
            log.execute();
        }
    }
}
