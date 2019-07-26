package io.study.xmltag;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * <rpc:xxx></rpc:xxx> 标签解析器
 */
public class RpcBeanDefinitionParser implements BeanDefinitionParser {
    /**
     * eg. RpcConfig
     */
    private Class<?> beanClass;

    public RpcBeanDefinitionParser(Class<?> aClass) {
        this.beanClass = aClass;
    }

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        // 1. 创建 BeanDefinition
        RootBeanDefinition rootBD = new RootBeanDefinition();
        rootBD.setBeanClass(beanClass);
        rootBD.getPropertyValues().add("id", element.getAttribute("id"));
        rootBD.getPropertyValues().add("timeout", element.getAttribute("timeout"));
        // 2. 注册 BeanDefinition 到 BeanDefinitionRegistry 中
        BeanDefinitionRegistry registry = parserContext.getRegistry();
        registry.registerBeanDefinition(beanClass.getName(), rootBD);
        return rootBD;
    }
}
