package io.study.compiler;

import com.alibaba.dubbo.common.compiler.Compiler;
import com.alibaba.dubbo.common.compiler.support.AdaptiveCompiler;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * @author zhaojigang
 * @date 2019/7/20
 */
public class TestDubboCompiler {

    public static void main(String[] args) throws Exception {
        String code = "package io.study.compiler;\n" +
                "public class HelloWorld {\n" +
                "    public void sayHello(){\n" +
                "        System.out.println(\"hello\");\n" +
                "    }\n" +
                "}";
        // 设置使用的编译器类型
        AdaptiveCompiler.setDefaultCompiler("javassist");
        // 获取 Compiler 适配类
        Compiler compiler = ExtensionLoader.getExtensionLoader(Compiler.class).getAdaptiveExtension();
        // 编译
        Class<?> aClass = compiler.compile(code, Thread.currentThread().getContextClassLoader());
        // 调用
        aClass.getMethod("sayHello", new Class[]{}).invoke(aClass.newInstance(), new Object[]{});
    }
}
