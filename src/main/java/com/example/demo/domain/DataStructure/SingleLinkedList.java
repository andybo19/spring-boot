package com.example.demo.domain.DataStructure;

public class SingleLinkedList {

    private Node head;//头部结点

    private int size;//链表的结点个数

    public SingleLinkedList(){//构造器
        this.head =null;
        this.size = 0;
    }

    //内部类,定义一个链表结点
     class Node {
        private Object data;//每个结点的数据
        private Node next;//每个结点指向下一个结点的连接

        public Node(Object data){ //构造器
            this.data = data;
        }

        @Override
        public String toString(){
            return data.toString();
        }

    }


    //添加头部结点
    public Object addHead(Object obj){
        Node newNode = new Node(obj);
        if(head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        size++;
        return obj;
    }

    //删除头部结点
    public Object delHead(){
        if(size >0){
            Object obj = head.data;
            head = head.next;
            size--;
            return obj;
        }
        return null;
    }

    //删除指定元素
    public Node del(Object obj){
        Node current = head;
        Node previous = head;
        while(!current.data.equals(obj)){
            if(current.next ==null){
                return null;
            }else{
                current = current.next;
            }
        }
        if(current == head){
            head = current.next;
            size--;
        }else{
            previous.next = current.next;
            size--;
        }
        return current;
    }

    //查找指定元素
    public Object find(Object obj){
        Node current = head;
        while(!current.data.equals(obj)){
            if(current.next ==null){
                return null;
            }else{
                current = current.next;
            }
        }
        return current.data;
    }
    //判断链表是否为空
    public boolean isEmpty(){
      return (size == 0);
    }

     //显示节点信息
    public void display(){
            Node current = head;
            int tempSize = size;
            if(tempSize == 1){
                System.out.println("["+current.data+"]");
                return;
            }
            while (tempSize >0){
                if(current.equals(head)){
                    System.out.print("["+current.data+"->");
                }else if(current.next == null){
                    System.out.print(current.data+"]");
                }else{
                    System.out.print(current.data+"->");
                }
                current = current.next;
                tempSize--;
            }
    }


}
