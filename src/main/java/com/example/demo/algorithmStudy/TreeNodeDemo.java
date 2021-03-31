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
        int [] post = {7, 4, 2, 5, 8, 6, 3, 1};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        List<Integer> list = new ArrayList<>();
        List<Integer> postorder = postorder(list, treeNode);
        System.out.println(postorder);

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

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
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


                stack.push(new ColorNode(node,"gary"));

                if(node.right != null){
                    stack.push(new ColorNode(node.right,"white"));
                }


                if(node.left != null){
                    stack.push(new ColorNode(node.left,"white"));
                }


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

                /*if(node.left != null){
                    deque.offerLast(node.left);
                }*/

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

    //二叉树右视图 199
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root == null){
            return list;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();

        Queue<Object> st = new LinkedList<>();

        queue.offerLast(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size;i++){
                TreeNode node = queue.pollFirst();
                if(node.left != null){
                    queue.offerLast(node.left);
                }

                if(node.right != null){
                    queue.offerLast(node.right);
                }

                if(i == size -1){
                    list.add(node.val);
                }
            }

        }
        return list;
    }

    //二叉树的层平均值 637
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();

        if(root == null){
            return list;
        }

        LinkedList<TreeNode> queue  = new LinkedList<>();

        queue.offerLast(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            double sum = 0.0;
            for(int i =0 ;i < size;i++){
                TreeNode node = queue.pollFirst();
                sum += node.val;

                if(node.left != null){
                    queue.offerLast(node.left);
                }

                if(node.right != null){
                    queue.offerLast(node.right);
                }
            }
            list.add(sum / size);
        }

        return list;
    }

    //N叉树的层序遍历 429
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();

        if(root == null){
            return list;
        }

        LinkedList<Node> queue = new LinkedList<>();

        queue.offerLast(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> arrList  = new ArrayList<>();
            for(int i = 0; i < size ; i++){
                Node node = queue.pollFirst();
                arrList.add(node.val);

                List<Node> childrens = node.children;

                for(int j = 0; j <  childrens.size() ; j++){
                    Node child = childrens.get(j);
                    queue.offerLast(child);
                }

            }
            list.add(arrList);
        }
        return list;
    }

    //翻转二叉树 226
    public TreeNode invertTree(TreeNode root) {
        //递归函数的终止条件，节点为空时返回
        if(root==null) {
            return null;
        }
        //下面三句是将当前节点的左右子树交换
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        //递归交换当前节点的 左子树
        invertTree(root.left);
        //递归交换当前节点的 右子树
        invertTree(root.right);
        //函数返回时就表示当前这个节点，以及它的左右子树
        //都已经交换完了
        return root;
    }

    //对称二叉树 101
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        LinkedList<TreeNode> queue  = new LinkedList<>();

        queue.add(root.left);
        queue.add(root.right);

        while(queue.size() > 0){

            TreeNode left = queue.poll();

            TreeNode right = queue.poll();

            if(left == null && right == null){
                continue;
            }

            if(left == null || right == null ){
                return false;
            }

            if(left.val != right.val){
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);

        }
        return true;
    }

    //二叉树的最大深度 104
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        LinkedList<TreeNode> queue  = new LinkedList<>();

        queue.add(root);

        int sum = 0;

        while(queue.size() > 0){

            sum += 1;
            int size  = queue.size();

            for(int i = 0; i < size; i++ ){
                TreeNode node = queue.poll();

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }

            }

        }
        return sum;

    }


    //二叉树最小深度 111
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        int depth = 0;

        while(queue.size() > 0){


            int size = queue.size();

            for(int i = 0; i< size; i++){
                TreeNode  node = queue.pop();
                if(node.left == null && node.right == null){
                    return depth += 1;
                }

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
            }

            depth += 1;

        }
        return depth;
    }


    //平衡二叉树 110
    public static boolean isBalanced(TreeNode root){
        return recur(root) != -1;
    }

    public static int recur(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = recur(root.left);
        if(left == -1){
            return -1;
        }

        int right = recur(root.right);
        if(right == -1){
            return  -1;
        }

        return Math.abs(left - right) > 1 ? -1 : Math.max(left,right) + 1;
    }


    //最大二叉树
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return recur(nums,0,nums.length);
    }

    public TreeNode recur(int[]nums,int low,int high){
        if(low >= high){
            return null;
        }

        int maxValue = Integer.MIN_VALUE;
        int index =0;
        for(int i = low; i< high;i++){
            if(nums[i] > maxValue){
                maxValue = nums[i];
                index = i;
            }
        }
        TreeNode node = new TreeNode(maxValue);
        node.left = recur(nums,low,index);
        node.right = recur(nums,index + 1,high);
        return node;

    }

}
