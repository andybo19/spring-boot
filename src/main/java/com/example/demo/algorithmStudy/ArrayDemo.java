package com.example.demo.algorithmStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mayongbo
 * @Description
 * @date 2020/9/18 15:07
 */
public class ArrayDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,2,4,3};
        //reOrderArray(arr);
        System.out.println("排序后"+ Arrays.toString(arr));
        //int index = searchRight(arr, 9) -searchRight(arr,8) ;
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int length = matrix.length;
        for(int i = 0;i<length;i++){
            int[] array = matrix[i];
            System.out.println(Arrays.toString(array));
        }
        System.out.println("++++++++++++++++");
        /*int[] ints = printMatrix(matrix);
        System.out.println("查找结果:" + Arrays.toString(ints));*/
        System.out.println("++++++++++++++++");
        System.out.println("查找结果:" + printMatrixOrder(matrix));

    }


    public static void reOrderArray(int[] array) {
        int length = array.length;
        if(length <= 1){
            return;
        }

        int i =0;
        while (i < length){
            if(array[i] % 2 ==0){
                int j = i + 1;
                while (array[j] % 2 ==0){
                    if(j == length -1){
                        return;
                    }
                    j++;
                }
                int count = j - i;
                int tmp = array[i];
                array[i] = array[j];
                while (count >1){
                    array[i + count] = array[ i + count - 1];
                    count--;
                }
                array[i + 1] = tmp;
            }
            i++;
        }
    }

    public static int findTarget(int[] array,int target){
        int min = -1;
        int max = array.length;
        while (min < max -1){
            int mid = (min + (max - min)) / 2;
            if(array[mid] == target){
                return mid;
            }else if(array[mid] < target){
                min = mid;
            }else if(array[mid] > target){
                max = mid;
            }
        }
        return -1;
    }

    public static int searchTarget(int[] array,int target){
        int left = 0;
        int right = array.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(array[mid] == target){
                return mid;
            }else if(array[mid] < target){
                left = mid + 1;
            }else if(array[mid] > target){
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int searchRight(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid  = left + (right - left) / 2;
            if(arr[mid] == target){
                left = mid + 1;
            }else if(arr[mid] < target){
                left = mid + 1;
            }else if(arr[mid] > target){
                right = mid - 1;
            }
        }
        return right;
    }


    public static int searchLeft(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1; // 注意

        while (left <= right) { // 注意
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1; // 注意
            }
        }
        /*if (left >= nums.length || nums[left] != target){
            return -1;
        }*/
        return left;
    }

    //删除元素 27
    public static int removeElement(int[] nums, int target){
        int length = nums.length;
        for(int i = 0; i<length;i++){
            if(nums[i] == target){
                for(int j= i + 1;j<length;j++){
                    nums[j -1] = nums[j];
                }
                i--;
                length--;
            }
        }
        return length;

    }

    public static int removeElement2(int[] nums, int val){
        int slowIndex = 0;
        for(int fastIndex = 0; fastIndex<nums.length;fastIndex++){
            if(nums[fastIndex] != val){
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;

    }

    //最小子长度 209
    public static int minLength(int[] nums, int val){
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int subLength = 0;
        for(int i = 0; i< nums.length ;i++){
            sum = 0;
            for(int j = i;j< nums.length;j++){
                sum += nums[j];
                if(sum >= val){
                    subLength = j - i + 1;
                    result = result < subLength ? result : subLength;
                    break;
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static int minLengthWindow(int[] nums, int target){
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int subLength = 0;
        int slowIndex = 0;
        for(int fastIndex = 0; fastIndex<nums.length;fastIndex++){
            sum += nums[fastIndex];
            while (sum >= target){
                subLength = fastIndex - slowIndex + 1;
                result = result < subLength ? result : subLength;
                sum -= nums[slowIndex++];

            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    //螺旋矩阵 59
    public static int[][] screwMatrix(int n){
        int[][] res = new int[n][n];
        int startx = 0;
        int starty = 0;
        int loop = n/2;
        int mid = n/2;
        int count =1;
        int offset = 1;
        int i,j;
        while (loop > 0){
            for (j = starty;j < starty + n - offset;j++){
                res[startx][j] = count++;
            }
            for (i = startx;i < startx + n - offset;i++){
                res[i][j] = count++;
            }
            for(;j > starty;j--){
                res[i][j] = count++;
            }
            for(;i > startx;i--){
                res[i][j] = count++;
            }
            startx++;
            starty++;

            offset+=2;
            loop--;
        }
        if(n % 2 == 1){
            res[mid][mid] = count;
        }
        return res;
    }

    public static int[][] screwMatrix2(int n){
        int[][] res = new int[n][n];
        int left = 0;
        int right = n -1;
        int up = 0;
        int down = n -1;
        int i = 1;
        while ( i <= n*n){
            for (int col = left;col <= right;col++){
                res[up][col] = i++;
            }
            ++up;
            for (int row = up;row <=  down;row++){
                res[row][right] = i++;
            }
            --right;
            for(int col=right;col >= left;col--){
                res[down][col] = i++;
            }
            --down;
            for(int row = down;row >=up ;row--){
                res[row][left] = i++;
            }
            ++left;
        }
        return res;
    }

    //输出螺旋矩阵 54
    public static int[] printMatrix(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[m*n];
        int left =0;
        int right = n -1;
        int up =0;
        int down = m -1;
        int i = 0;
        while (i < m *n){
            for(int col = left;col <= right;col++){
                arr[i++] = matrix[up][col];
            }
            ++up;
            for(int row = up;row <= down;row++){
                arr[i++] = matrix[row][right];
            }
            --right;
            for(int col = right; col >=left;col--){
                arr[i++] = matrix[down][col];
            }
            --down;
            for(int row = down; row >=up;row--){
                arr[i++] = matrix[row][left];
            }
            ++left;
        }
        return arr;

    }

    public static List<Integer> printMatrixOrder(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[m*n];
        int left =0;
        int right = n -1;
        int up =0;
        int down = m -1;
        List<Integer> list = new ArrayList<>(m * n);
        while (list.size() <  m * n){
            for(int col = left;col <= right;col++){
                list.add(matrix[up][col]);
            }
            if(list.size() >=  m * n){
                break;
            }
            ++up;
            for(int row = up;row <= down;row++){
                list.add(matrix[row][right]);
            }
            if(list.size() >=  m * n){
                break;
            }
            --right;
            for(int col = right; col >=left;col--){
                list.add(matrix[down][col]);
            }
            if(list.size() >=  m * n){
                break;
            }
            --down;
            for(int row = down; row >=up;row--){
                list.add(matrix[row][left]);
            }
            if(list.size() >=  m * n){
                break;
            }
            ++left;
        }
        return list;

    }
}
