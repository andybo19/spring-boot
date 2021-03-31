package com.example.demo.basisStudy;

/**
 * @author mayongbo
 * @Description
 * @date 2021/3/30 15:55
 */
public class IntegerAddDemo {

    public static void main(String[] args) {
        int j = 0;
        for (int i = 0; i < 10; i++) {
            j = (++j);
        }
        System.out.println(j);


        int i = 4;
        int b = i++;
        int a = ++i;
        System.out.println("b: "+b);
        System.out.println("a: "+a);
    }

}
