package io.study.dubbo.spi.activate;

import com.alibaba.dubbo.common.extension.Activate;

@Activate(value = {"multi"})
public class MultiValue implements Log {
    @Override
    public void execute() {
        System.out.println("this is multi value!");
    }
}
