package io.study.dubbo.spi.aop;

/**
 * wrapper 类也必须实现 SPI 接口，否则 loadClass() 处报错
 */
public class LogWrapper2 implements Log {
    private Log log;

    /**
     * wrapper 类必须有一个含有单个 Log 参数的构造器
     */
    public LogWrapper2(Log log) {
        this.log = log;
    }

    @Override
    public void execute() {
        System.out.println("LogWrapper2 before");
        log.execute();
        System.out.println("LogWrapper2 after");
    }
}
