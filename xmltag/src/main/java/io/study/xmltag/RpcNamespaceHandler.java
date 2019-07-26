package io.study.xmltag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 命名空间处理类
 */
public class RpcNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        // 注册 <rpc:provider> 标签的解析器
        // key:elementName - eg.provider，value:解析器
        registerBeanDefinitionParser("provider", new RpcBeanDefinitionParser(RpcConfig.class));
    }
}
