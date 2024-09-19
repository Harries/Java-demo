package com.et;

// 该接口的实现类
class RealService implements Service {
    @Override
    public void perform() {
        System.out.println("Real Service is performing...");
    }
}