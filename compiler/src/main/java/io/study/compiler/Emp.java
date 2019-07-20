package io.study.compiler;

/**
 * 目标类
 */
public class Emp {
    /**
     * 属性
     */
    private String name;
    private int age;

    /**
     * 构造方法
     */
    public Emp() {
        this.name = "xiaona";
        this.age = 1;
    }

    /**
     * getter 和 setter
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 普通方法
     */
    public void commonMethod() {
        System.out.println("haha");
    }
}
