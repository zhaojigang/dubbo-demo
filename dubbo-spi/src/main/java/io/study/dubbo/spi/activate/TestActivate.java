package io.study.dubbo.spi.activate;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

import java.util.List;

public class TestActivate {
    public static void main(String[] args) {
        ExtensionLoader<Log> loader = ExtensionLoader.getExtensionLoader(Log.class);
        testGroup(loader);
        testValue(loader);
    }

    /**
     * 1. 测试 group
     * 仅仅过滤出@Activate.groups包含url传入的group=xxx参数
     */
    private static void testGroup(ExtensionLoader<Log> loader) {
        System.out.println("======================= 测试 group =======================");
        URL url = new URL("dubbo", "10.211.55.6", 8080);
        String group = "provider";
        String[] values = new String[]{};
        List<Log> activateExtension = loader.getActivateExtension(url, values, group);
        /**
         * 输出：
         * this is single group!
         * this is multi group!
         */
        activateExtension.forEach(Log::execute);
    }

    /**
     * 2. 测试 value
     */
    private static void testValue(ExtensionLoader<Log> loader) {
        System.out.println("======================= 测试 value =======================");
        URL url = new URL("dubbo", "10.211.55.6", 8080);
//        url = url.addParameter("groupAndValue", "gv");
        String[] values = new String[]{"sv", "-mg"};
        /**
         * NoCondition @Activate                                    no
         * SingleGroup @Activate(group = {"provider"}, order = 1)   sg
         * MultiGroup  @Activate(group = {"provider", "consumer"}, order = 2)  mg
         * SingleValue @Activate(value = {"singleValue"})           sv
         * MultiValue  @Activate(value = {"multi"})                 mv
         * GroupAndValue @Activate(group = {"provider", "consumer"}, value = {"groupAndValue"})  gv
         *
         * 1.首先加载 default 激活点（除了 "sv", "mg"之外的其他激活点），加载条件：
         *   我们加了 group 参数，首先会获取具有相关 group 的组，这里获取到 SingleGroup、GroupAndValue，
         *   由于 SingleGroup 没有配置 values 属性，所以认为激活，而 GroupAndValue 的 value 值的任一元素（groupAndValue）没有出现在 url.getParameter中，
         *   所以 GroupAndValue 不能加载（如果加上该句 url = url.addParameter("groupAndValue", "gv"); 代码，则可以加载）
         *   最后对所有的 default 激活点按照 order、before、after 属性进行排序
         * 2.之后加载 usr 激活点（"sv", "mg" 激活点），sv 正常加载，而 mg 我们配置的 values 是 -mg，也就是说不加载 mg
         */
        List<Log> activateExtension = loader.getActivateExtension(url, values, "provider");
        /**
         * 输出：
         * this is single group!
         * this is single value!
         */
        activateExtension.forEach(Log::execute);
    }
}
