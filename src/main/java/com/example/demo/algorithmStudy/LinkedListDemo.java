package com.example.demo.algorithmStudy;

import java.util.LinkedList;

/**
 * @author mayongbo
 * @Description
 * @date 2021/3/11 16:24
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(6);
        node3.next = node4;
        ListNode node5 = new ListNode(4);
        node4.next = node5;
        ListNode node6 = new ListNode(5);
        node5.next = node6;
        ListNode node7 = new ListNode(6);
        node6.next = node7;
        node7.next = node2;
        //System.out.println(getLinkListStr(head));
        System.out.println("========================");
        boolean hasCycle = hasCycle(head);
        //ListNode elements = removeElements(head, 7);
        ListNode listNode = detectCycle(head);
        System.out.println(getLinkListStr(reverseListNode(head)));
        LinkedList<Object> list = new LinkedList<>();
/*        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        int num1 =linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        int num2 =linkedList.get(1);            //返回3
        System.out.println("==============");*/

    }

    public static String getLinkListStr(ListNode head){
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        ListNode cur = head;
        while (cur != null){
            builder.append(cur.val);
            cur = cur.next;
            if(cur != null){
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }


    public static ListNode removeElements(ListNode head, int val){
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel;
        ListNode cur = head;
        while (cur != null){
            if(cur.val == val){
                prev.next = cur.next;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }

        return sentinel.next;

    }

    //链表反转 206
    public static ListNode reverseListNode(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        ListNode tmp = null;

        while (cur != null){

            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }

        return prev;

    }

    //链表有环判断 141
    public static boolean hasCycle(ListNode head){
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    //链表有环的入环节点 142
    public static ListNode detectCycle(ListNode head){
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode prev = head;
                while (prev != slow){
                    prev = prev.next;
                    slow = slow.next;
                }
                return prev;
            }

        }
        return null;


        /*if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;*/

    }
}
