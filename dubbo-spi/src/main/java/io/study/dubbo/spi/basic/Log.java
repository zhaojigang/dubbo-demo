package io.study.dubbo.spi.basic;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * SPI 接口
 * value() 指定默认的 SPI 实现类的 key
 */
@SPI("logback")
public interface Log {
    void execute();
}
