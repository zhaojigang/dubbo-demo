package io.study.dubbo.spi.aop;

/**
 * Log4j 实现类
 */
public class Log4j implements Log {
    @Override
    public void execute() {
        System.out.println("this is log4j!");
    }
}
