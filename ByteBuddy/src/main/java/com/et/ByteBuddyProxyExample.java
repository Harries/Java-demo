package com.et;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.reflect.InvocationTargetException;

public class ByteBuddyProxyExample {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Create an original object
        Foo foo = new Foo();

        // Use ByteBuddy to create a proxy
        Foo proxy = (Foo) new ByteBuddy()
                .subclass(Foo.class)
                .method(ElementMatchers.any()) // Intercept all methods
                .intercept(MethodDelegation.to(new Interceptor())) // Delegate to the Interceptor class
                .make()
                .load(Foo.class.getClassLoader())
                .getLoaded()
                .getDeclaredConstructor()
                .newInstance();

        // Call the method
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

        public String intercept(String sss,String bbbb) {
            return " two parameters";
        }
    }
}