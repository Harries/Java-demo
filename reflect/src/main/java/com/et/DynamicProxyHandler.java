package com.et;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class DynamicProxyHandler implements InvocationHandler {

    private Object realObject;

    // construct
    public DynamicProxyHandler(Object realObject) {
        this.realObject = realObject;
    }

    // method invoker
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method: " + method.getName());
        //invoker the real method
        Object result = method.invoke(realObject, args);
        System.out.println("After method: " + method.getName());
        return result;
    }
}