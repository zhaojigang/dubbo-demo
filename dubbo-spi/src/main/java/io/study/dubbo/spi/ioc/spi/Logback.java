package io.study.dubbo.spi.ioc.spi;

import com.alibaba.dubbo.common.URL;

/**
 * Logback 实现类
 */
public class Logback implements Log {

    /**
     * SPI IOC 注入：
     * Book 是 SPI 接口，
     * 必须存在一个 public ooo setXxx(单个SPI接口) 的方法才可以进行 IOC 注入，
     * 且被注入的 SPI 接口必须有适配类（无论是手动还是自动）
     */
    private Book book;

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public void execute() {
        URL url = new URL("dubbo", "10.211.55.5", 8080);
        System.out.println("this is logback! " + book.bookName(url.addParameter("language", "go")));
    }
}
