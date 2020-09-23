package com.example.demo.algorithmStudy;

/**
 * @author mayongbo
 * @Description
 * @date 2020/9/18 9:59
 */
public class JumpFloorDemo {

    public static void main(String[] args) {
        int result = JumpFloor(2);
        System.out.println(result);
    }

    public static int JumpFloor(int target) {
        if(target == 0 || target == 1){
            return 1;
        }
        return JumpFloor(target - 1) + JumpFloor(target -2);
    }

}
