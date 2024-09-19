package com.et;

import java.lang.reflect.Proxy;

public class DynamicProxyExample {
    public static void main(String[] args) {
        // real service
        RealService realService = new RealService();

        // create Dynamic proxy
        Service proxyInstance = (Service) Proxy.newProxyInstance(
            realService.getClass().getClassLoader(),      // classloader
            realService.getClass().getInterfaces(),       // interface
            new DynamicProxyHandler(realService)          // real class
        );

        // invoke
        proxyInstance.perform();
    }
}