package com.company;


import sun.misc.URLClassPath;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class JvmClassLoaderPrintPath {
    public static void main(String[] args) {
        printExtClassLoader();
    }

    public static void printBoostrapClassPath() {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        System.out.println("启动类加载器");
        for (int i = 0; i < urls.length; i++) {
            System.out.println("url:" + urls[i]);
        }
    }

    public static void printClassLoader(ClassLoader classLoader) {
        try {
            Object urlClassLoaderPath = null;
            if(classLoader instanceof URLClassLoader){
                Field f = URLClassLoader.class.getDeclaredField("ucp");
                f.setAccessible(true);
                urlClassLoaderPath = f.get(classLoader);
            }else{
                Field f = classLoader.getClass().getDeclaredField("ucp");
                f.setAccessible(true);
                urlClassLoaderPath = f.get(classLoader);
            }
            Field path = URLClassPath.class.getDeclaredField("path");
            path.setAccessible(true);
            ArrayList pathList = (ArrayList) path.get(urlClassLoaderPath);
            for (Object obj : pathList) {
                System.out.println(obj.toString());
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void printExtClassLoader(){
        ClassLoader extClassLoader = JvmClassLoaderPrintPath.class.getClassLoader().getParent();
        printClassLoader(extClassLoader);
    }


}
