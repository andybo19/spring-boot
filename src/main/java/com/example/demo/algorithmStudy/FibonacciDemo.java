package com.example.demo.algorithmStudy;

/**
 * @author mayongbo
 * @Description
 * @date 2020/9/18 9:52
 */
public class FibonacciDemo {

    public static void main(String[] args) {
        int result = Fibonacci(2);
        System.out.println(result);
    }

    public static int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }
        int[] arr = new int[n + 1];
        arr[0] =0;
        arr[1] =1;
        for(int i = 2;i<= n;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n];
    }

}
