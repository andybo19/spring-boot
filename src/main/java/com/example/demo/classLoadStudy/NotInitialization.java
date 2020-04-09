package com.example.demo.classLoadStudy;

/**
 * @author mayongbo
 * @Description
 * @date 2020/4/9 18:02
 */
public class NotInitialization {

    //1.遇到new,getstatic,putstatic,invokestatic这失调字节码指令时，如果类没有进行过初始化，则需要先触发其初始化。生成这4条指令的最常见的Java代码场景是：使用new关键字实例化对象的时候、读取或设置一个类的静态字段（被final修饰、已在编译器把结果放入常量池的静态字段除外）的时候，以及调用一个类的静态方法的时候。
    //2.使用java.lang.reflect包的方法对类进行反射调用的时候，如果类没有进行过初始化，则需要先触发其初始化。
    //3.当初始化一个类的时候，如果发现其父类还没有进行过初始化，则需要先触发其父类的初始化。
    //4.当虚拟机启动时，用户需要指定一个要执行的主类（包含main()方法的那个类），虚拟机会先初始化这个主类。
    //5.当使用jdk1.7动态语言支持时，如果一个java.lang.invoke.MethodHandle实例最后的解析结果REF_getstatic,REF_putstatic,REF_invokeStatic的方法句柄，并且这个方法句柄所对应的类没有进行初始化，则需要先出触发其初始化。

    public static void main(String[] args) {
        System.out.println(SubClass.b);
        SuperClass[] classes = new SuperClass[10];
    }

}
