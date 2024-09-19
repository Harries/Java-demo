package com.et;

import java.lang.reflect.Proxy;

public class DynamicProxyExample {
    public static void main(String[] args) {
        // 创建实际对象
        RealService realService = new RealService();

        // 创建动态代理对象
        Service proxyInstance = (Service) Proxy.newProxyInstance(
            realService.getClass().getClassLoader(),      // 类加载器
            realService.getClass().getInterfaces(),       // 被代理类实现的接口
            new DynamicProxyHandler(realService)          // 代理处理类
        );

        // 调用代理对象的方法
        proxyInstance.perform();
    }
}