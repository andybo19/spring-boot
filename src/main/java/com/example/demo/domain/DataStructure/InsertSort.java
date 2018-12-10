package com.example.demo.domain.DataStructure;

import java.util.Arrays;

public class InsertSort {
    public static int[] sort(int[] array){
        for(int i=1;i<array.length;i++){
            for(int j=i;j>0;j--){
                if(array[j] < array[j - 1]){
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
            //第i轮的排序结果
            System.out.println("第"+i+"轮排序后的结果为:"+ Arrays.toString(array));
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
        System.out.println("经过插入排序后的数组顺序为：");
        System.out.println(Arrays.toString(array));
    }

}
