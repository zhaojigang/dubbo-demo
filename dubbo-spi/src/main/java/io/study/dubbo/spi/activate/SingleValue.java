package io.study.dubbo.spi.activate;

import com.alibaba.dubbo.common.extension.Activate;

@Activate(value = {"singleValue"})
public class SingleValue implements Log {
    @Override
    public void execute() {
        System.out.println("this is single value!");
    }
}
