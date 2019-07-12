package io.study.dubbo.spi.ioc.spi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

public class Book$Adaptive implements io.study.dubbo.spi.ioc.spi.Book {
    @Override
    public java.lang.String bookName(com.alibaba.dubbo.common.URL arg0) {
        if (arg0 == null) {
            throw new IllegalArgumentException("url == null");
        }
        com.alibaba.dubbo.common.URL url = arg0;
        String extName = url.getParameter("language", "java");
        if (extName == null) {
            throw new IllegalStateException("Fail to get extension(io.study.dubbo.spi.ioc.spi.Book) name from url(" + url.toString() + ") use keys([language])");
        }
        io.study.dubbo.spi.ioc.spi.Book extension = (io.study.dubbo.spi.ioc.spi.Book) ExtensionLoader.getExtensionLoader(io.study.dubbo.spi.ioc.spi.Book.class).getExtension(extName);
        return extension.bookName(arg0);
    }
}