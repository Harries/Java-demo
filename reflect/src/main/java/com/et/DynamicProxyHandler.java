package com.et;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 定义一个动态代理类，实现 InvocationHandler 接口
class DynamicProxyHandler implements InvocationHandler {

    private Object realObject;

    // 构造方法接收被代理的对象
    public DynamicProxyHandler(Object realObject) {
        this.realObject = realObject;
    }

    // 处理代理对象上的所有方法调用
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method: " + method.getName());
        // 调用实际对象上的方法
        Object result = method.invoke(realObject, args);
        System.out.println("After method: " + method.getName());
        return result;
    }
}