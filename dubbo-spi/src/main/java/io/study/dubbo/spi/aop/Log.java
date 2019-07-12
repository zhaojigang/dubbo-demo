package io.study.dubbo.spi.aop;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * SPI 接口
 */
@SPI("logback")
public interface Log {
    void execute();
}
