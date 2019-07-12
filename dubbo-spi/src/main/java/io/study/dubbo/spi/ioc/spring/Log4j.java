package io.study.dubbo.spi.ioc.spring;

/**
 * Log4j 实现类
 */
public class Log4j implements Log {

    /**
     * Book 是 SPI 接口，
     * 必须存在一个 public ooo setXxx(单个SPI接口) 的方法才可以进行 IOC 注入，
     * 且被注入的 SPI 接口必须有适配类（无论是手动还是自动）
     */
    private Book book;

    public void setGoBook(Book book) {
        this.book = book;
    }

    @Override
    public void execute() {
        System.out.println("this is log4j!" + book.bookName());
    }
}