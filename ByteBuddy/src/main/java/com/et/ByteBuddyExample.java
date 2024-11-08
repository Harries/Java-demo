package com.et;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.FixedValue;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class ByteBuddyExample {
    public static void main(String[] args) {
        try {
            // 使用ByteBuddy创建一个新的类
            Class<?> dynamicType = new ByteBuddy()
                .subclass(Object.class) // 继承自Object类
                .name("com.example.HelloWorld") // 定义类名
                .method(named("toString")) // 定义方法
                .intercept(FixedValue.value("Hello, ByteBuddy!")) // 方法返回固定值
                .make()
                .load(ByteBuddyExample.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();

            // 创建类的实例并调用toString方法
            Object instance = dynamicType.getDeclaredConstructor().newInstance();
            System.out.println(instance.toString()); // 输出: Hello, ByteBuddy!
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}