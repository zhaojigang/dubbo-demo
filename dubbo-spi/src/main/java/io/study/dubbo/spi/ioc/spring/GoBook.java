package io.study.dubbo.spi.ioc.spring;

public class GoBook implements Book {
    @Override
    public String bookName() {
        return "this is go book！";
    }
}
