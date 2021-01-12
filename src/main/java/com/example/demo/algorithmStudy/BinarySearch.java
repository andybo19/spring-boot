package com.example.demo.algorithmStudy;

/**
 * @author mayongbo
 * @Description
 * @date 2020/12/16 14:34
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,2,2,4};
        int target =2;
        int binarySearch = binarySearch(arr, target);
        int binarySearchLeft = binarySearchLeft(arr, target);
        int binarySearchRight = binarySearchRight(arr, target);
        System.out.println("binarySearch: " + binarySearch);
        System.out.println("binarySearchLeft: " + binarySearchLeft);
        System.out.println("binarySearchRight: " + binarySearchRight);
    }


    public static int binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = left + (right -  left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] == target){
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearchLeft(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = left + (right -  left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] == target){
                right = mid - 1;
            }
        }
        if(left >= nums.length || nums[left] != target){
            return -1;
        }
        return left;
    }

    public static int binarySearchRight(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = left + (right -  left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] == target){
                left = mid + 1;
            }
        }
        if(right < 0 || nums[right] != target){
            return -1;
        }
        return right;
    }

}
