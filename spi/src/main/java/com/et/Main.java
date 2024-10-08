package com.et;

import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
            ServiceLoader<SearchService> serviceLoader = ServiceLoader.load(SearchService.class);
            System.out.println("============ Java SPI test===========");
            serviceLoader.forEach(loader -> System.out.println(loader.search("Yes Or No")));
        }

}