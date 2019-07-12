package io.study.dubbo.spi.adaptive.manual;

/**
 * Logback 实现类
 */
public class Logback implements Log {
    @Override
    public void execute(String name) {
        System.out.println("this is logback! " + name);
    }
}
