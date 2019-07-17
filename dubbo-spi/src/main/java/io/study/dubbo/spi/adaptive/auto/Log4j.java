package io.study.dubbo.spi.adaptive.auto;

import com.alibaba.dubbo.common.URL;

/**
 * Log4j 实现类
 */
public class Log4j implements Log {
    @Override
    public void execute(URL url) {
        System.out.println("this is log4j! " + url.getIp());
    }

    @Override
    public void test() {}
}
