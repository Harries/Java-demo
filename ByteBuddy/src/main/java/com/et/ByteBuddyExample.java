package com.et;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.FixedValue;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class ByteBuddyExample {
    public static void main(String[] args) {
        try {
            // ʹ��ByteBuddy����һ���µ���
            Class<?> dynamicType = new ByteBuddy()
                .subclass(Object.class) // �̳���Object��
                .name("com.example.HelloWorld") // ��������
                .method(named("toString")) // ���巽��
                .intercept(FixedValue.value("Hello, ByteBuddy!")) // �������ع̶�ֵ
                .make()
                .load(ByteBuddyExample.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();

            // �������ʵ��������toString����
            Object instance = dynamicType.getDeclaredConstructor().newInstance();
            System.out.println(instance.toString()); // ���: Hello, ByteBuddy!
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}