package com.example.demo.algorithmStudy;

/**
 * @author mayongbo
 * @Description
 * @date 2020/9/14 17:47
 */
public class DynamicProgram {

    /**
     * 动态规划
     * 1.状态定义
     * 2.转移方程
     * @param args
     */

    public static void main(String[] args) {
        int result = function(7);
        System.out.println("+++++++++++++++++"+result);
        int resultDynamic = DynamicFunction(7);
        System.out.println("+++++++++++++++++"+resultDynamic);

    }

    public static int function(int n){
        if(n == 0 || n == 1 ){
            return 1;
        }
        return function(n - 1) + function(n - 2);

    }


    public static int DynamicFunction(int n){
        if(n == 0 || n == 1 ){
            return 1;
        }

        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }


}
