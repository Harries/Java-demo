package com.et;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ByteBuddyProxyExample {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 创建一个原始对象
        Foo foo = new Foo();

        // 使用ByteBuddy创建代理
        Foo proxy = (Foo) new ByteBuddy()
                .subclass(Foo.class)
                .method(ElementMatchers.any()) // 拦截所有方法
                .intercept(MethodDelegation.to(new Interceptor())) // 委托给Interceptor类
                .make()
                .load(Foo.class.getClassLoader())
                .getLoaded()
                .getDeclaredConstructor()
                .newInstance();

        // 调用方法
        System.out.println(proxy.sayHello());
    }

    public static class Foo {
        public String sayHello() {
            return "Hello from Foo";
        }
    }

    public static class Interceptor {
        @BindingPriority(3)
        public String sssintercept() {
            return "ssss";
        }
        @BindingPriority(2)
        public String intercept() {
            return "Hello from Interceptor";
        }
    }
}