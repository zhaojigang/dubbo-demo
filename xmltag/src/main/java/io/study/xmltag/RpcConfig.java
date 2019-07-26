package io.study.xmltag;

/**
 * xml 标签类
 */
public class RpcConfig {
    private String id;
    private int timeout;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
