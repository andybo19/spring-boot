package com.example.demo.domain.DataStructure;

import java.util.Arrays;

public class ChoiceSort {
    public static int[] sort(int[] array){
        for(int i=0;i<array.length - 1;i++){
            int min = i;
            for(int j = i + 1;j<array.length;j++){
                if(array[j] < array[min]){
                    min = j;
                }
            }
            if( i != min){
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
            System.out.println("第"+(i+1)+"轮排序后的结果为:"+ Arrays.toString(array));
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
    }
}
