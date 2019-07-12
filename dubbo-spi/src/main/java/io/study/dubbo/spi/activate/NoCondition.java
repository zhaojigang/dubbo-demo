package io.study.dubbo.spi.activate;

import com.alibaba.dubbo.common.extension.Activate;

@Activate
public class NoCondition implements Log {
    @Override
    public void execute() {
        System.out.println("this is noCondition!");
    }
}
