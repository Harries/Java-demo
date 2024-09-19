package com.et;


class RealService implements Service {
    @Override
    public void perform() {
        System.out.println("Real Service is performing...");
    }
}