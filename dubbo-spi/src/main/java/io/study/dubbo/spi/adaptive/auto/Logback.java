package io.study.dubbo.spi.adaptive.auto;

import com.alibaba.dubbo.common.URL;

/**
 * Logback 实现类
 */
public class Logback implements Log {
    @Override
    public void execute(URL url) {
        System.out.println("this is logback! " + url.getIp());
    }

    @Override
    public void test() {

    }
}
