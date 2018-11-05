package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private static boolean ready;

    private static int number;

    private static class  ReaderThread extends Thread{
        public void run(){
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }
    public static void main(String[] args) {
       /* int[] arr = {1, 4, 5, 3};
        int target =10;
        int[] result = getResult(arr, target);
        System.out.println(Arrays.toString(result));*/

        /*String str = "()[{}]";
        System.out.println(getCheckResult(str));*/
        new ReaderThread().start();
        number =42;
        ready = true;

    }

    public static  int[] getResult(int[] array,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<array.length;i++) {
            Integer index = map.get(target - array[i]);
            if(index == null){
                map.put(array[i],i);
            }else {
                return new int[]{index,i};
            }
        }
        return new int[]{0,0};
    }

    public static Integer getStrResult(String str){
        char[] array = str.toCharArray();
        Long result = 0L;
        Integer length = 0;
        boolean flag = true;
        Integer startIndex = 0;
        for(int i = 0;i <array.length;i++){
            if(startIndex == i){
                if(array[i]==' '){
                    startIndex++;
                    continue;
                }
                if(array[i] =='+' || array[i] == '0'){
                    continue;
                }
                if(array[i] == '-'){
                    flag = false;
                    continue;
                }
            }
            if(array[i] >= '0' && array[i] <= '9'){
                result = result * 10 + array[i] - '0';
                length++;
                if(length>10){
                    break;
                }
            }else{
                break;
            }
        }
        if(flag){
            if(result > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }else{
            result = -result;
            if(result < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return result.intValue();
    }

    public static boolean getCheckResult(String str){
        char[] chars = str.toCharArray();
        List<Character> list = new ArrayList<>();
        for(int i=0;i<chars.length;i++){
            char c = chars[i];
            if(c=='(' || c=='{' || c=='['){
                list.add(c);
            }else{
                if(list.size() == 0){
                    return false;
                }
                Character last = list.get(list.size() - 1);
                if(c==')'&& last !='('){
                    return false;
                }else if(c=='}'&& last !='{'){
                    return false;
                }else if(c==']'&& last !='['){
                    return false;
                }
                list.remove(list.size() - 1);
            }
        }
        if(list.size() != 0){
            return false;
        }
        return true;
    }
}
