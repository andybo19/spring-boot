package com.example.demo.algorithmStudy;

import java.util.Arrays;

/**
 * @author mayongbo
 * @Description 贪心算法
 * @date 2021/3/4 16:53
 */
public class GreedDemo {

    public static void main(String[] args) {
        int[] g = new int[]{1,2};
        int[] s = new int[]{1,2,3};
        int children = findContentChildren(g, s);
        System.out.println(children);
        System.out.println("=========================");
        int[] candies = new int[]{1,1,2,2,3,3};
        int count = distributeCandies(candies);
        System.out.println(count);
        System.out.println("=========================");
        int[] ratings =  new int[]{1,2,2};
        int candy = candy(ratings);
        System.out.println(candy);
        System.out.println("=========================");
    }

    //分发饼干
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int cookie = 0;
        while (child < g.length && cookie < s.length){
            if(g[child] <= s[cookie]){
                child++;
            }
            cookie++;
        }
        return child;
    }

    //糖果种类
    public static int distributeCandies(int[] candies){
        Arrays.sort(candies);
        int count = 1;
        for(int i = 1; i< candies.length && count < candies.length /2;i++){
            if(candies[i] > candies[i -1]){
                count++;
            }
        }
        return count;
    }

    //至少需要多少糖果
    public static int candy(int[] ratings) {
        int[] candies  = new int[ratings.length];
        for(int i = 0; i< candies.length;i++){
            candies[i] = 1;
        }
        for (int i = 1; i< ratings.length;i++){
            if(ratings[i] > ratings[i -1]){
                candies[i] = candies[i - 1] + 1;
            }
        }

        for(int j = ratings.length - 1; j > 0;j--){
            if(ratings[j -1] > ratings[j]){
                candies[j - 1] =Math.max(candies[j -1],candies[j] + 1);
            }
        }
        int sum = 0;
        for(int i = 0; i< candies.length;i++){
            sum += candies[i];
        }
        return sum;
    }


}
