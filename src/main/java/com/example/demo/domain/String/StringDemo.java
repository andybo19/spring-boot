package com.example.demo.domain.String;

public class StringDemo {

    public static void main(String[] args) {
       /* String str1="aaa";
        String str2="aaa";
        System.out.println(str1==str2);*/


        /*String str3=new String("aaa");
        String str4=new String("aaa");
        System.out.println(str3==str4);//false 可以看出用new的方式是生成不同的对象*/

        /*String s0="helloworld";
        String s1="helloworld";
        String s2="hello"+"world";
        System.out.println(s0==s1); //true 可以看出s0跟s1是指向同一个对象
        System.out.println(s0==s2); //true 可以看出s0跟s2是指向同一个对象*/


        /*String s0="helloworld";
        String s1=new String("helloworld");
        String s2="hello" + new String("world");
        System.out.println("===========test4============");
        System.out.println( s0==s1 ); //false
        System.out.println( s0==s2 ); //false
        System.out.println( s1==s2 ); //false*/

        /*String str1="abc";
        String str2="def";
        String str3=str1+str2;
        System.out.println(str3=="abcdef"); //false*/

        /*String str3="hello";
        String str4="he"+ "llo";
        System.out.println(str3 == str4);*/

        String s0 = "ab";
        String s1 = "b";
        String s2 = "a" + s1;
        System.out.println("===========test7============");
        System.out.println((s0 == s2)); //result = false
    }
}
