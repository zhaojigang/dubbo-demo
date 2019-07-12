package io.study.dubbo.spi.ioc.spi;

import com.alibaba.dubbo.common.extension.DisableInject;

/**
 * Log4j 实现类
 */
public class Log4j implements Log {

    /**
     * SPI IOC 注入：
     * Book 是 SPI 接口，
     * 必须存在一个 public ooo setXxx(单个SPI接口) 的方法才可以进行 IOC 注入，
     * 且被注入的 SPI 接口必须有适配类（无论是手动还是自动）
     */
    private Book book;

    // @DisableInject 禁用 IOC 注入
    @DisableInject
    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public void execute() {
        System.out.println("this is log4j!");
    }
}
