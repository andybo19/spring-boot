package com.example.demo.algorithmStudy;

import lombok.Data;

import java.util.LinkedList;

/**
 * @author mayongbo
 * @Description
 * @date 2020/9/17 11:33
 */
@Data
public class TreeNodeTest {

    private int val;
    private TreeNodeDemo.TreeNode left;
    private TreeNodeDemo.TreeNode right;
    public TreeNodeTest(int val){
        this.val = val;
    }

    public static void main(String[] args) {
        /*TwoStackQueue queue = new TwoStackQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println("出队列"+queue.pop());
        queue.push(5);
        System.out.println("出队列"+queue.pop());*/

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(null);
        list.add(2);
        System.out.println("============" + list.toString());


    }

}
