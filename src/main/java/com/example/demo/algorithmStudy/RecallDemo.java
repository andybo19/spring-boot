package com.example.demo.algorithmStudy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mayongbo
 * @Description
 * @date 2020/12/15 14:22
 *
 *
 * result = []
 * def backtrack(路径, 选择列表):
 *     if 满足结束条件:
 *         result.add(路径)
 *         return
 *
 *     for 选择 in 选择列表:
 *         做选择
 *         backtrack(路径, 选择列表)
 *         撤销选择
 */
public class RecallDemo {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        LinkedList<Integer> track = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums,track,res);
        System.out.println("+++++++++++++++");
        System.out.println(res);
    }


    public static void  backTrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> res){
        if(track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }

        for (int num : nums) {
            if(track.contains(num)){
                continue;
            }
            track.add(num);
            backTrack(nums, track, res);
            track.removeLast();
        }

    }

}
