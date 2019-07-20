package io.study.compiler;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.Modifier;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author zhaojigang
 * @date 2019/7/19
 */
public class TestJavassist {
    public static void main(String[] args) throws Exception {
        ClassPool pool = new ClassPool(true);
        CtClass ctClass = pool.makeClass("io.study.compiler.Emp");

        /**
         * private String name
         */
        CtField nameField = new CtField(pool.getCtClass("java.lang.String"), "name", ctClass);
        nameField.setModifiers(Modifier.PRIVATE);
        ctClass.addField(nameField);

        /**
         * private int age
         */
        CtField ageField = new CtField(pool.getCtClass("int"), "age", ctClass);
        ageField.setModifiers(Modifier.PRIVATE);
        ctClass.addField(ageField);

        /**
         * public Emp() {
         *   this.name = "xiaona";
         *   this.age = 1;
         * }
         */
        CtConstructor constructor = new CtConstructor(new CtClass[]{}, ctClass);
        String body = new StringBuilder("{this.name = \"xiaona\";\nthis.age = 1;}").toString();
        constructor.setBody(body);
        ctClass.addConstructor(constructor);

        /**
         * public String getName() {
         *   return name;
         * }
         *
         * public void setName(String name) {
         *   this.name = name;
         * }
         */
        ctClass.addMethod(CtNewMethod.getter("getName", nameField));
        ctClass.addMethod(CtNewMethod.setter("setName", nameField));

        /**
         * public void commonMethod() {
         *   System.out.println("haha");
         * }
         */
        CtMethod commonMethod = new CtMethod(CtClass.voidType, "commonMethod", new CtClass[]{}, ctClass);
        commonMethod.setModifiers(Modifier.PUBLIC);
        commonMethod.setBody(new StringBuilder("{\n System.out.println(\"haha\"); \n}").toString());
        ctClass.addMethod(commonMethod);

        /**
         * 创建 Class
         */
        Class<?> aClass = ctClass.toClass();
        /**
         * 创建对象
         */
        Object instance = aClass.newInstance();
        /**
         * 调用方法
         */
        instance.getClass().getMethod("commonMethod", new Class[]{}).invoke(instance, new Object[]{});
        /**
         * 将字节码输出到文件中
         */
        toFile(ctClass);
    }

    private static void toFile(CtClass ctClass) throws IOException, CannotCompileException {
        byte[] codeByteArray = ctClass.toBytecode();
        FileOutputStream fos = new FileOutputStream(new File("/Users/jigangzhao/Desktop/Emp.class"));
        fos.write(codeByteArray);
        fos.close();
    }
}
