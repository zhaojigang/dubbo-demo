package io.study.dubbo.spi.ioc.spring;

/**
 * Logback 实现类
 */
public class Logback implements Log {
    /**
     * Spring IOC 注入：
     * 1. 必须存在一个 public ooo setXxx(其中 Xxx 是 Spring bean 的名称) 的方法才可以进行 IOC 注入，
     */
    private Book book;

    /**
     * 这里注入的就是 javaBook 这个 Bean
     */
    public void setJavaBook(Book book) {
        this.book = book;
    }

    @Override
    public void execute() {
        System.out.println("this is logback! " + book.bookName());
    }
}