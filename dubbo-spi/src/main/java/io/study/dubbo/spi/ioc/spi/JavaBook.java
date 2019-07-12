package io.study.dubbo.spi.ioc.spi;

import com.alibaba.dubbo.common.URL;

public class JavaBook implements Book {
    @Override
    public String bookName(URL url) {
        return "this is java book！" + url.getIp();
    }
}
