package com.example.demo.algorithmStudy;

import java.util.Arrays;

/**
 * @author mayongbo
 * @Description
 * @date 2020/9/18 15:07
 */
public class ArrayDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        reOrderArray(arr);
        System.out.println("排序后"+ Arrays.toString(arr));
    }


    public static void reOrderArray(int [] array) {
        int length = array.length;
        if(length <= 1){
            return;
        }

        int i =0;
        while (i < length){
            if(array[i] % 2 ==0){
                int j = i + 1;
                while (array[j] % 2 ==0){
                    if(j == length -1){
                        return;
                    }
                    j++;
                }
                int count = j - i;
                int tmp = array[i];
                array[i] = array[j];
                while (count >1){
                    array[i + count] = array[ i + count - 1];
                    count--;
                }
                array[i + 1] = tmp;
            }
            i++;
        }
    }
}
