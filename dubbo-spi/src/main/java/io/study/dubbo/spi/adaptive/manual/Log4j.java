package io.study.dubbo.spi.adaptive.manual;

/**
 * Log4j 实现类
 */
public class Log4j implements Log {
    @Override
    public void execute(String name) {
        System.out.println("this is log4j! " + name);
    }
}
