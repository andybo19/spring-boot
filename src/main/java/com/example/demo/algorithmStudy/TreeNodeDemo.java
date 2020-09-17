package com.example.demo.algorithmStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mayongbo
 * @Description
 * @date 2020/9/17 9:47
 */
public class TreeNodeDemo {

    public static void main(String[] args) {
        int [] pre = {1,2,4,7,3,5,6,8};
        int [] in =  {4,7,2,1,5,3,8,6};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        List<Integer> list = new ArrayList<>();
        postOrderTraverse1(list, treeNode);
        System.out.println(list);

    }



    public static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if(pre.length == 0 || in.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0 ; i < in.length ; i++) {
            if(in[i] == pre[0]){
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }

    public TreeNodeTest reConstructBinaryTreeNodeTest(int [] pre,int [] in) {
        if(pre.length == 0 || in.length == 0){
            return null;
        }
        TreeNodeTest root = new TreeNodeTest(pre[0]);
        for (int i = 0 ; i < in.length ; i++) {
            if(in[i] == pre[0]){
                root.setLeft(reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i)));
                root.setRight(reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length)));
                break;
            }
        }
        return root;
    }

    public static List<Integer> preOrderTraverse1(List<Integer> list, TreeNode root){
        if(root != null){
            System.out.println(root.val + "->");
            list.add(root.val);
            preOrderTraverse1(list,root.left);
            preOrderTraverse1(list,root.right);
        }
        return list;
    }

    public static List<Integer> inOrderTraverse1(List<Integer> list, TreeNode root){
        if(root != null){
            inOrderTraverse1(list,root.left);
            System.out.println(root.val + "->");
            list.add(root.val);
            inOrderTraverse1(list,root.right);
        }
        return list;
    }

    public static List<Integer> postOrderTraverse1(List<Integer> list, TreeNode root){
        if(root != null){
            postOrderTraverse1(list,root.left);
            postOrderTraverse1(list,root.right);
            System.out.println(root.val + "->");
            list.add(root.val);
        }
        return list;
    }
}
