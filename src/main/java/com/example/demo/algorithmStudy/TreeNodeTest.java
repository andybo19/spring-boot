package com.example.demo.algorithmStudy;

import lombok.Data;

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

}
