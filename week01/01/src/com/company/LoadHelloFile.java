package com.company;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.Vector;

public class LoadHelloFile {

    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class helloClass = myClassLoader.loadClass("Hello.xlass");
        try {
            Object helloObj = helloClass.newInstance();
            Method method = helloClass.getMethod("hello");
            method.invoke(helloObj);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }


}

class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (name.equals("Hello.xlass")) {
            File file = new File("//Users/xxxx/Documents/geekbang/src/com/company/Hello.xlass");
            System.out.println(file.toPath());
            try {
                byte[] result = Files.readAllBytes(file.toPath());
                for (int i = 0; i < result.length; i++) {
                    result[i] = (byte) (255 - (int)result[i]);
                }
                return defineClass("Hello",result,0,result.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.findClass(name);
    }





}


