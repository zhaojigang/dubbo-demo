package io.study.dubbo.spi.activate;

import com.alibaba.dubbo.common.extension.Activate;

// order 值越小，则排在集合前边，order 默认为 0
@Activate(group = {"provider"}, order = 1)
public class SingleGroup implements Log {
    @Override
    public void execute() {
        System.out.println("this is single group!");
    }
}
