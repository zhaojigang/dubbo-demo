package io.study.dubbo.spi.ioc.spi;

import com.alibaba.dubbo.common.URL;

public class GoBook implements Book {
    @Override
    public String bookName(URL url) {
        return "this is go book！" + url.getIp();
    }
}
