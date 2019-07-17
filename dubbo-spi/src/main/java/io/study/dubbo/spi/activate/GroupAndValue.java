package io.study.dubbo.spi.activate;

import com.alibaba.dubbo.common.extension.Activate;

/**
 * @author zhaojigang
 * @date 2019/7/17
 */
@Activate(group = {"provider", "consumer"}, value = {"groupAndValue"})
public class GroupAndValue implements Log {
    @Override
    public void execute() {
        System.out.println("this is GroupAndValue!");
    }
}
