package io.study.dubbo.spi.activate;

import com.alibaba.dubbo.common.extension.Activate;

@Activate(group = {"provider", "consumer"}, order = 2)
public class MultiGroup implements Log {
    @Override
    public void execute() {
        System.out.println("this is multi group!");
    }
}
