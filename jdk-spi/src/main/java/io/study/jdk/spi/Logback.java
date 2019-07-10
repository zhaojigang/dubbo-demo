package io.study.jdk.spi;

/**
 * Logback 实现类
 */
public class Logback implements Log {
    @Override
    public void execute() {
        System.out.println("this is logback!");
    }
}
