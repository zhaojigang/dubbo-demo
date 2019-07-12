package io.study.dubbo.spi.ioc.spring;

public class JavaBook implements Book {
    @Override
    public String bookName() {
        return "this is java book！";
    }
}
