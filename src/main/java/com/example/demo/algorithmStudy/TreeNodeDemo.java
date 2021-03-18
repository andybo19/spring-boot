package com.example.demo.algorithmStudy;

import java.util.*;

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
        List<List<Integer>> lists = levelOrder(treeNode);
        System.out.println(lists);

    }



    public static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        TreeNode(int val){
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
      }
    }

    public static class ColorNode{
        TreeNode node;
        String color;

        ColorNode(TreeNode node,String color){
            this.node = node;
            this.color = color;
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

    public static List<Integer> preOrderStack(List<Integer> list, TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return list;
    }

    public static List<Integer> inOrderStack(List<Integer> list, TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur  = cur.left;
            }
            TreeNode node  = stack.pop();
            list.add(node.val);
            if(node.right != null){
                cur = node.right;
            }
        }
        return list;
    }

    public static List<Integer> postorder(List<Integer> list,TreeNode root) {
        if(root == null){
            return list;
        }
        Stack<ColorNode> stack = new Stack<>();

        stack.push(new ColorNode(root,"white"));

        while(!stack.isEmpty()){
            ColorNode colorNode =  stack.pop();

            TreeNode node = colorNode.node;

            if("white".equals(colorNode.color)){


                if(node.right != null){
                    stack.push(new ColorNode(node.right,"white"));
                }

                if(node.left != null){
                    stack.push(new ColorNode(node.left,"white"));
                }

                stack.push(new ColorNode(node,"gary"));
            }else {
                list.add(node.val);
            }
        }
        return list;
    }

    //层序遍历 102
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list  = new ArrayList<>();
        if(root == null){
            return list;
        }

        Deque<TreeNode> deque = new LinkedList<>();

        deque.offerLast(root);

        while (!deque.isEmpty()){
            int size = deque.size();

            List<Integer> arrayList = new ArrayList<>();

            for(int i = 0; i <size;i++){
                TreeNode node = deque.pollFirst();
                arrayList.add(node.val);

                if(node.left != null){
                    deque.offerLast(node.left);
                }

                if(node.right != null){
                    deque.offerLast(node.right);
                }
            }
            list.add(arrayList);
        }
        return list;
    }

    //层序遍历 107
    public static List<List<Integer>> levelOrderReverse(TreeNode root) {
        List<List<Integer>> list  = new ArrayList<>();
        if(root == null){
            return list;
        }

        Deque<TreeNode> deque = new LinkedList<>();

        deque.offerLast(root);

        while (!deque.isEmpty()){
            int size = deque.size();

            List<Integer> arrayList = new ArrayList<>();

            for(int i = 0; i <size;i++){
                TreeNode node = deque.pollFirst();
                arrayList.add(node.val);

                if(node.left != null){
                    deque.offerLast(node.left);
                }

                if(node.right != null){
                    deque.offerLast(node.right);
                }
            }
            list.add(arrayList);
        }
        Collections.reverse(list);
        return list;
    }




}
