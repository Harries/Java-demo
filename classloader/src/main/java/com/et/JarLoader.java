package com.et;

import java.net.URL;
import java.net.URLClassLoader;
import java.lang.reflect.Method;
import java.io.File;

public class JarLoader {
    private URLClassLoader urlClassLoader;

    // load JAR file
    public void loadJar(String jarFilePath) throws Exception {
        File jarFile = new File(jarFilePath);
        URL jarUrl = jarFile.toURI().toURL();
        urlClassLoader = new URLClassLoader(new URL[]{jarUrl}, this.getClass().getClassLoader());
        System.out.println("JAR Loaded: " + jarFilePath);
    }

    //load class from  JAR and invoke method
    public void invokeClassMethod(String className, String methodName) throws Exception {
        if (urlClassLoader != null) {
            Class<?> loadedClass = urlClassLoader.loadClass(className);
            Method method = loadedClass.getDeclaredMethod(methodName);
            method.invoke(loadedClass.newInstance());
            System.out.println("Method Invoked: " + methodName);
        } else {
            System.out.println("ClassLoader is null, load a JAR first.");
        }
    }

    // unload JAR
    public void unloadJar() throws Exception {
        if (urlClassLoader != null) {
            urlClassLoader.close();  // close ClassLoader
            urlClassLoader = null;    // let it recycle by jvm
            System.out.println("JAR Unloaded.");
        } else {
            System.out.println("No JAR to unload.");
        }
    }
}
