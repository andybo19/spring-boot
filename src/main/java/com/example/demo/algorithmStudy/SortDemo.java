package com.example.demo.algorithmStudy;

import java.util.Arrays;

/**
 * @author mayongbo
 * @Description
 * @date 2021/3/17 16:04
 */
public class SortDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,2,4,3};
        int[] ints = sortBubblee(arr);
        System.out.println("===============" + Arrays.toString(ints));
    }


    public static int[] sortChoice(int[] nums){
        for(int i =0; i<nums.length;i++){
            int min = i;
            for(int j = i + 1;j<nums.length;j++){
                if(nums[i] > nums[j]){
                    min = j;
                }
            }
            if(i != min){
                int tmp =nums[i];
                nums[i] = nums[min];
                nums[min] = tmp;
            }
        }
        return nums;
    }

    public static int[] sortBubblee(int[] nums){
        for(int i =0; i<nums.length;i++){
            boolean flag = true;
            for(int j = 1;j<nums.length - i;j++){
                if(nums[j] < nums[j - 1]){
                    int tmp =nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
        return nums;
    }
}
