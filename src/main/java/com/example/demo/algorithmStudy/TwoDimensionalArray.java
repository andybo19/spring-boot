package com.example.demo.algorithmStudy;

/**
 * @author mayongbo
 * @Description
 * @date 2020/9/14 19:01
 */
public class TwoDimensionalArray {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target =6;
        boolean easy = findEasy(15, arr);
        System.out.println("++++++++++++++"+easy);
        boolean effectResult = find(15, arr);
        System.out.println("++++++++++++++"+effectResult);
    }

    public static boolean findEasy(int target, int[][] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j< array[i].length; j++){
                if(array[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean find(int target, int[][] array){
        int rows = array.length;
        if(rows == 0){
            return false;
        }
        int cols = array[0].length;
        if(cols == 0){
            return false;
        }
        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0){
            if(array[row][col] > target){
                col--;
            }else if(array[row][col] < target){
                row++;
            }else {
                return true;
            }
        }
        return false;
    }



}
