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

    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k ==0){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 0;i < k; i++){
            if(fast == null){
                return null;
            }
            fast = fast.next;
        }
         while (fast != null){
             slow = slow.next;
             fast = fast.next;
         }
        return slow;
    }

    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode p = null;
        while (head != null){
            p = head.next;
            head.next = pre;
            pre = head;
            head = p;
        }
        return pre;
    }




    public static class ListNode{

        int val;
        ListNode next = null;

        public ListNode(int val){
            this.val = val;
        }
    }
}
