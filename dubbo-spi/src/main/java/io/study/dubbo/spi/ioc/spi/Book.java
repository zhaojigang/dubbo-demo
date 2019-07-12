package io.study.dubbo.spi.ioc.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * SPI IOC 注入方式：必须有适配类（无论是手动还是自动）
 * note：手动编写的 Adaptive 类内也可以实现 IOC 注入
 */
@SPI("java")
public interface Book {
    @Adaptive({"language"})
    String bookName(URL url);
}
