package io.study.dubbo.spi.activate;

import com.alibaba.dubbo.common.extension.SPI;

@SPI
public interface Log {
    void execute();
}
