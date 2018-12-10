package com.example.demo.domain.DataStructure;

import java.util.Arrays;

public class HillSort {

    public static int[] sort(int[] array){
        //增量
        int incrementNum = array.length/2;
        while(incrementNum >=1){
            for(int i=incrementNum;i<array.length;i++){
                //进行插入排序
                System.out.println("步进"+incrementNum+"第"+(i -incrementNum)+"轮排序开始:+++++++++++++"+Arrays.toString(array));
                /*for(int j=i;j<array.length-incrementNum;j=j+incrementNum){
                    if(array[j]>array[j+incrementNum]){
                        int temple = array[j];
                        array[j] = array[j+incrementNum];
                        array[j+incrementNum] = temple;
                    }else{
                        break;
                    }
                System.out.println("第"+j+"轮排序后的结果为:"+ (j+incrementNum)+"结果为"+Arrays.toString(array));
                }*/
                for(int j=i;j>=incrementNum;j=j-incrementNum){
                    if(array[j]<array[j-incrementNum]){
                        int temple = array[j];
                        array[j] = array[j-incrementNum];
                        array[j-incrementNum] = temple;
                    }else{
                        break;
                    }
                    System.out.println("步进"+incrementNum+"第"+(i -incrementNum)+"轮排序结果:+++++++++++++"+Arrays.toString(array));
                }
            }
            //设置新的增量
            incrementNum = incrementNum/2;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {4,2,8,9,5,7,6,1};
        System.out.println("未排序数组顺序为：");
        System.out.println(Arrays.toString(array));
        System.out.println("-----------------------");
        sort(array);
        System.out.println("-----------------------");
        System.out.println("经过插入排序后的数组顺序为：");
        System.out.println(Arrays.toString(array));
    }

}
