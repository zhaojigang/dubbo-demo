package io.study.dubbo.spi.adaptive.auto;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * SPI 接口
 */
@SPI("logback")
public interface Log {

    /**
     * 含有 @Adaptive 注解的方法，生成的动态类会实现该方法，该方法必须直接包含 URL 参数或者方法的参数中要包含 URL 参数
     * @Adaptive 注解中的 String[] value() 代表 url 中用于获取 SPI 实现类的 key 的参数名：
     *
     * eg. 本例的配置生成的代码如下
     * String extName = url.getParameter("xxx", url.getParameter("ooo", "logback")); // 其中 logback 是默认值, 即先获取 Url 中key为xxx的值，如果该值存在，则使用该值去 SPI 配置文件中获取对应的实现
     * Log extension = ExtensionLoader.getExtensionLoader(Log.class).getExtension(extName);
     */
    @Adaptive({"xxx","ooo"})
    void execute(URL url);

    /**
     * 不带有 @Adaptive 注解的方法，生成的动态类中该方法的方法体直接抛异常
     */
    void test();
}
