package com.et;

public class Main {
    public static void main(String[] args) throws Exception {
        JarLoader jarLoader = new JarLoader();

        // load JAR
        jarLoader.loadJar("D:\\IdeaProjects\\Java-demo\\demo\\target\\demo-1.0-SNAPSHOT.jar");

        // invoke the method
        jarLoader.invokeClassMethod("com.et.demo.service.MockService", "printVersion");

        // unload JAR
        jarLoader.unloadJar();
    }
}
