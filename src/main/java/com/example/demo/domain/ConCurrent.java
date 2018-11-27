package com.example.demo.domain;

import java.util.List;

public class ConCurrent {

    public static void main(String[] args) {
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统/应用类加载器：" + appClassLoader);
        //获取系统/应用类加载器的父类加载器，得到扩展类加载器
        ClassLoader extcClassLoader = appClassLoader.getParent();
        System.out.println("扩展类加载器" + extcClassLoader);
        System.out.println("扩展类加载器的加载路径：" + System.getProperty("java.ext.dirs"));
        //获取扩展类加载器的父加载器，但因根类加载器并不是用Java实现的所以不能获取
        System.out.println("扩展类的父类加载器：" + extcClassLoader.getParent());


        System.out.println("**********************************");
        //输出ClassLoaderText的类加载器名称
        System.out.println("ConCurrent类的加载器的名称:"+ConCurrent.class.getClassLoader().getClass().getName());
        ClassLoader cl = ConCurrent.class.getClassLoader();
        while(cl != null){
            System.out.print(cl.getClass().getName()+"->");
            cl = cl.getParent();
        }
        System.out.println("+++++++++++++"+cl);
        System.out.println("System类的加载器的名称:"+System.class.getClassLoader());
        ClassLoader c2 = System.class.getClassLoader();
        while(c2 != null){
            System.out.print(c2.getClass().getName()+"->");
            c2 = c2.getParent();
        }
        System.out.println("List类的加载器的名称:"+List.class.getClassLoader());
        ClassLoader c3= List.class.getClassLoader();
        while(c3 != null){
            System.out.print(c3.getClass().getName()+"->");
            c3 = c3.getParent();
        }



    }
}
