package com.example.demo.algorithmStudy;

import java.util.*;

/**
 * @author mayongbo
 * @Description
 * @date 2021/3/15 17:47
 */
public class StackQueueDemo {

    public static void main(String[] args) {
/*        String str = "abbaca";
        String removeDuplicates = removeDuplicates(str);
        System.out.println("==========" + removeDuplicates);*/
        /*int[] arr = new int[]{7,2,4};
        int[] window = maxSlidingWindow(arr, 2);
        System.out.println("==========" + Arrays.toString(window));*/
        String str = "/a/./b/../../c/";
        String result = simplifyPath(str);
        System.out.println("==========" + result);

    }

    //有效的括号 20
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack();
        int n = s.length();
        if(n % 2 == 1){
            return false;
        }

        Map<Character,Character> pairs = new HashMap<Character,Character>();
        pairs.put('(',')');
        pairs.put('[',']');
        pairs.put('{','}');

        for (int i = 0;i<n;i++) {
            char ch = s.charAt(i);
            if(pairs.containsKey(ch)){
                stack.push(pairs.get(ch));
            }else if(stack.empty() || stack.pop() != s.charAt(i)){
                return false;
            }
        }
        return stack.empty();
    }

    //删除字符串中的所有相邻重复项 1047
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack();
        int n = s.length();
        for (int i = 0;i < n;i++) {
            char ch = s.charAt(i);
            if(!stack.empty() && ch == stack.peek()){
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        StringBuilder str = new StringBuilder();
        for (Character character : stack) {
            str.append(character);
        }
        return str.toString();

    }

    //逆波兰表达式求值 150
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for (int i = 0 ; i < tokens.length; i++) {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                if(tokens[i].equals("+")){
                    stack.push(num2 + num1);
                }
                if(tokens[i].equals("-")){
                    stack.push(num2 - num1);
                }
                if(tokens[i].equals("*")){
                    stack.push(num2 * num1);
                }
                if(tokens[i].equals("/")){
                    stack.push(num2 / num1);
                }
            }else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }

    //滑动窗口最大值 239
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> queue = new LinkedList<>();

        for (int i =0 ; i< k; i++){
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offerLast(i);
        }

        int[] result = new int[n - k + 1];
        result[0] = nums[queue.peekFirst()];
        for(int i = k; i< n; i++){
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offerLast(i);
            while (queue.peekFirst() <= i - k){
                queue.pollFirst();
            }
            result[i - k + 1] = nums[queue.peekFirst()];
        }
        return result;

    }

    //前 K 个高频元素 347
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i,map.getOrDefault(i,0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer count = entry.getValue();
            if(queue.size() >= k){
                if(map.get(queue.peek()) < count){
                    queue.poll();
                    queue.offer(key);
                }
            }else {
                queue.offer(key);
            }
        }
        int[] result = new int[k];
        for(int i = k -1; i >=0; i--){
            result[i] = queue.poll();
        }
        return result;
    }

    //简化路径 71
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        String[] strArr = path.split("/");
        for (int i = 0 ; i < strArr.length; i++) {
            if(strArr[i].length() == 0 || strArr[i].equals(".")){
                continue;
            }
            if(!stack.isEmpty()){
                if(strArr[i].equals("..")){
                    stack.pop();
                }else {
                    stack.push(strArr[i]);
                }
            }else {
                if(!strArr[i].equals("..")){
                    stack.push(strArr[i]);
                }
            }
        }
        if(stack.isEmpty()){
            return "/";
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()){
            builder.insert(0,stack.pop());
            builder.insert(0,"/");
        }

        return builder.toString();

    }
}
