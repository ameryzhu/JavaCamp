package com.company;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ReflectionTest {
    public static void main(String[] args) {
        A a = new A();
        Field fields[] = a.getClass().getDeclaredFields();
        Field fields2[] = a.getClass().getSuperclass().getDeclaredFields();
//        System.out.println(Arrays.toString(fields));
//        System.out.println(Arrays.toString(fields2));
    }
}

class A extends B {
    private String n;
}

class B {
    String m;
}
