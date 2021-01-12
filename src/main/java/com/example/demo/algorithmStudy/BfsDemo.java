package com.example.demo.algorithmStudy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mayongbo
 * @Description
 * @date 2020/12/16 10:13
 */
public class BfsDemo {

    public static void main(String[] args) {

    }

    public static int getMax(int[][] graph){
        int res = 0;
        for (int i = 0; i < graph.length ; i++ ) {
            for (int j = 0; j < graph[0].length ; j++){
                int cur = 0;
                Queue<Integer> queuei = new LinkedList<>();
                Queue<Integer> queuej = new LinkedList<>();
                queuei.offer(i);
                queuej.offer(j);
                while (!queuei.isEmpty()){
                    Integer cur_i = queuei.poll();
                    Integer cur_j = queuej.poll();
                    if(cur_i < 0 || cur_j < 0 || cur_i >= graph.length || cur_j >= graph[0].length || graph[cur_i][cur_j] != 1){
                        continue;
                    }
                    ++cur;
                    graph[cur_i][cur_j] = 0;
                    int[] di = {0,0,1,-1};
                    int[] dj = {1,-1,0,-0};
                    for (int index = 0; index < 4 ; index ++){
                        int next_i = cur_j + di[index];
                        int next_j = cur_j + dj[index];
                        queuei.offer(next_i);
                        queuej.offer(next_j);

                    }
                }
                res = Math.max(res,cur);
            }
        }
        return res;
    }

}
