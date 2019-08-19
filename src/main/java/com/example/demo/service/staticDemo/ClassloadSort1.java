package com.example.demo.service.staticDemo;

public class ClassloadSort1 {
    //https://www.jianshu.com/p/202f6abb229c
    public static void main(String[] args) {
        Singleton.getInstance();
        System.out.println("Singleton value1:" + Singleton.value1);
        System.out.println("Singleton value2:" + Singleton.value2);

        Singleton2.getInstance2();
        System.out.println("Singleton2 value1:" + Singleton2.value1);
        System.out.println("Singleton2 value2:" + Singleton2.value2);
    }
}

class Singleton {
    static {
        System.out.println("value1:"+Singleton.value1 + "\t" +"value2:"+ Singleton.value2 + "\t" + Singleton.singleton);
        //System.out.println(Singleton.value1 + "\t" + Singleton.value2);
    }
    private static Singleton singleton = new Singleton();
    public static int value1 = 5;
    public static int value2 = 3;
    private Singleton() {
        System.out.println("构造器前"+"value1:"+Singleton.value1 + "\t" +"value2:"+ Singleton.value2 + "\t" + Singleton.singleton);
        value1++;
        value2++;
        System.out.println("构造器后"+"value1:"+Singleton.value1 + "\t" +"value2:"+ Singleton.value2 + "\t" + Singleton.singleton);
    }


    public static Singleton getInstance() {
        return singleton;
    }

    int count = 10;

    {
        System.out.println("count = " + count);
    }
}

class Singleton2 {
    static {
        System.out.println("value1:"+Singleton2.value1 + "\t" +"value2:"+ Singleton2.value2 + "\t" + Singleton2.singleton2);
    }

    public static int value1 = 5;
    public static int value2 = 3;
    private static Singleton2 singleton2 = new Singleton2();
    private String sign;

    int count = 20;
    {
        System.out.println("count = " + count);
    }

    private Singleton2() {
        System.out.println("构造器前"+"value1:"+Singleton2.value1 + "\t" +"value2:"+ Singleton2.value2 + "\t" + Singleton2.singleton2);
        value1++;
        value2++;
        System.out.println("构造器后"+"value1:"+Singleton2.value1 + "\t" +"value2:"+ Singleton2.value2 + "\t" + Singleton2.singleton2);
    }

    public static Singleton2 getInstance2() {
        return singleton2;
    }
}
