package io.study.dubbo.spi.activate;

import com.alibaba.dubbo.common.extension.Activate;

@Activate(group = {"provider"})
public class SingleGroup implements Log {
    @Override
    public void execute() {
        System.out.println("this is single group!");
    }
}
