package com.example.demo.algorithmStudy;

import java.util.*;

/**
 * @author mayongbo
 * @Description
 * @date 2021/3/12 16:25
 */
public class HashDemo {

    public static void main(String[] args) {
       /* String s = "anagram";
        String t = "nagarbm";
        boolean anagram = isAnagram(s, t);
        System.out.println("===================结果: " + anagram);*/
        int[] num1 = new int[]{4,9,5};
        int[] num2 = new int[]{9,4,9,8,4};
        int[] intersection = intersection(num1, num2);
        System.out.println("====================" + Arrays.toString(intersection));

    }

    //字符串异位 242
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> table = new HashMap<>();

        for (int i=0;i<s.length();i++) {
            char ca = s.charAt(i);
            table.put(ca,table.getOrDefault(ca,0) + 1);
        }

        for(int i= 0; i< t.length();i++){
            char ca = t.charAt(i);
            table.put(ca,table.getOrDefault(ca,0) - 1);
            if(table.get(ca) < 0){
                return false;
            }
        }
        return true;
    }

    //两个数组取交集 349
    public static int[] intersection(int[] nums1, int[] nums2){
        if(nums2.length < nums1.length){
            return intersection(nums2,nums1);
        }

        HashSet<Integer> resultSet = new HashSet<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : nums1) {
            hashSet.add(i);
        }

        for (int i : nums2) {
            if(hashSet.contains(i)){
                resultSet.add(i);
            }
        }

        int[] arr = new int[resultSet.size()];
        int index = 0;
        for (Integer i : resultSet) {
            arr[index++] = i;
        }
        return arr;

    }


    //快乐数 202
    public static boolean isHappy(int n){
        HashSet<Integer> set = new HashSet<>();
        while (true){
            Integer sum = getSum(n);
            if(sum == 1){
                return true;
            }

            if(set.contains(sum)){
                return false;
            }else {
                set.add(sum);
            }

            n = sum;
        }
    }

    public static int getSum(int n){
        int sum = 0;
        while (n > 0){
           sum += ( n % 10) * ( n % 10);
           n = n/10;
        }
        return sum;
    }

    //两数之和 1
    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            if(hashMap.containsKey(target - nums[i])){
                return new int[]{hashMap.get(target - nums[i]),i};
            }else {
                hashMap.put(nums[i],i);
            }
        }
        return new int[0];
    }

    //三数之和 15
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result  = new ArrayList<>();

        Arrays.sort(nums);


       if(nums == null || nums.length < 2){
           return result;

       }

        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right){
                if (nums[i] + nums[left] + nums[right] == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));


                    while (left < right && nums[left] == nums[left + 1]){
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return result;

    }

    //四数之和 18
    public static List<List<Integer>> fourSum(int[] nums,int target) {
        List<List<Integer>> result  = new ArrayList<>();

        Arrays.sort(nums);


        if(nums == null || nums.length < 4){
            return result;

        }

        for(int k = 0; k < nums.length; k++){

            if(k > 0 && nums[k] == nums[k - 1]){
                continue;
            }
            for (int i = k + 1;i < nums.length;i++){

                if(i > k + 1 && nums[i] == nums[i - 1]){
                    continue;
                }

                int left = i + 1;
                int right = nums.length - 1;

                while (left < right){
                    if (nums[k] + nums[i] + nums[left] + nums[right] == target) {
                        result.add(new ArrayList<>(Arrays.asList(nums[k],nums[i],nums[left],nums[right])));

                        while (left < right && nums[left] == nums[left + 1]){
                            left++;
                        }

                        while (left < right && nums[right] == nums[right - 1]){
                            right--;
                        }
                        left++;
                        right--;
                    }else if(nums[k] + nums[i] + nums[left] + nums[right] > target){
                        right--;
                    }else {
                        left++;
                    }
                }
            }
        }
        return result;

    }


    //四数之和2 454
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                hashMap.put( a + b,hashMap.getOrDefault(a + b,0) + 1);
            }
        }

        int count = 0;
        for (int c : C) {
            for (int d : D) {
                if(hashMap.containsKey(0 - ( c + d))){
                    count += hashMap.get(0 - ( c + d));
                }
            }
        }
        return count;
    }

    //赎金信 383
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> ransMap = new HashMap<>();
        HashMap<Character, Integer> magaMap = new HashMap<>();

        for(int i = 0; i< ransomNote.length();i++){
            char c = ransomNote.charAt(i);
            ransMap.put(c,ransMap.getOrDefault(c,0) + 1);
        }

        for(int i = 0; i< magazine.length();i++){
            char m = magazine.charAt(i);
            magaMap.put(m,magaMap.getOrDefault(m,0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : ransMap.entrySet()) {
            if(entry.getValue() > magaMap.getOrDefault(entry.getKey(),0)){
                return false;
            }
        }
        return true;

    }
}
