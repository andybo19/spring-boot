package com.example.demo.algorithmStudy;

/**
 * @author mayongbo
 * @Description
 * @date 2021/3/11 17:25
 */
public class MyLinkedList {

    private int size;

    private Node sentinel;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        sentinel = new Node(0);
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index > (size - 1) || index < 0){
            return -1;
        }
        Node cur = sentinel.next;
        for(int i = 0;i<index;i++){
            cur = cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
       addAtIndex(0,val);

    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index <= size && index >=0){
            Node node = new Node(val);
            Node prev = sentinel;
            Node cur = sentinel.next;
            for(int i = 0; i < index; i++){
                prev = prev.next;
            }
            node.next = prev.next;
            prev.next = node;
            size++;
        }


    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= 0 && index < size){
            Node prev = sentinel;
            for(int i = 0; i < index; i++){
                prev = prev.next;
            }
            prev.next = prev.next.next;
            size--;
        }
    }

    private static class Node{

        int val;
        Node next;
        Node() {}
        Node(int val) {
            this.val = val;
        }

    }

}
