package com.example.demo.algorithmStudy;

/**
 * @author mayongbo
 * @Description
 * @date 2020/12/16 10:13
 */
public class DfsDemo {

    public static void main(String[] args) {

    }

    public static int getMax(int[][] graph){
        int res = 0;
        for (int i = 0; i < graph.length ; i++ ) {
            for (int j = 0; j < graph[0].length ; j++){
                res = Math.max(res,dfs(graph,i,j));
            }
        }
        return res;
    }

    private static int dfs(int[][] graph, int cur_i, int cur_j) {
        if(cur_i < 0 || cur_j < 0 || cur_i >= graph.length || cur_j >= graph[0].length || graph[cur_i][cur_j] != 1){
            return 0;
        }
        graph[cur_i][cur_j] = 0;
        int[] di = {0,0,1,-1};
        int[] dj = {1,-1,0,-0};
        int res = 1;
        for (int index = 0; index < 4 ; index ++){
            int next_i = cur_j + di[index];
            int next_j = cur_j + dj[index];
            res += dfs(graph,next_i,next_j);

        }
        return res;
    }

}
