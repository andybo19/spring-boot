package com.example.demo.domain.DataStructure;

import java.util.Arrays;

public class BubbleSort {
    public static int[] sort(int[] array){
        for(int i= 1;i<array.length;i++){
            boolean flag = true;
            for(int j=0;j<array.length - i;j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j + 1];
                    array[j + 1]= array[j];
                    array[j] = temp;
                    flag = false;
                }
            }
            //第i轮的排序结果
            System.out.println("第"+i+"轮排序后的结果为:"+ Arrays.toString(array));
            if(flag){
                break;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {4,2,8,9,5,7,6,1,3};
        System.out.println("未排序数组顺序为：");
        System.out.println(Arrays.toString(array));
        System.out.println("-----------------------");
        sort(array);
        System.out.println("-----------------------");
        System.out.println("经过冒泡排序后的数组顺序为：");
        System.out.println(Arrays.toString(array));
        int x=5;
        int y=10;
        //swapBit(x,y);

    }

    public static void swap(int x,int y){
        int temp = x;
        x = y;
        y=temp;
        System.out.println("x= "+x);
        System.out.println("y= "+y);
    }

    public void swapBit(int x,int y){
        int temp = x^y;
        y=temp^y;
        x=temp^y;
    }
}
