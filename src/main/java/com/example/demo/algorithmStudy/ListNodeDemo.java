package com.example.demo.algorithmStudy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mayongbo
 * @Description
 * @date 2020/9/16 9:29
 */
public class ListNodeDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0,15);
        list.add(0,20);
        System.out.println("list+++++++"+list);
    }

    public List<Integer> printListFromTailToHead(ListNode listNode){
        List<Integer> list = new ArrayList<>();
        ListNode tmpNode = listNode.next;
        while (tmpNode != null){
            list.add(0,tmpNode.val);
            tmpNode = tmpNode.next;
        }
        return list;
    }




    public static class ListNode{

        int val;
        ListNode next = null;

        public ListNode(int val){
            this.val = val;
        }
    }
}
