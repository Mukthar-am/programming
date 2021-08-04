package com.muks.java.dsc.linkedlist;

public class ZLinnkedListTests {
    public static void main(String[] args) {


        LinkedList linkedList = new LinkedList();
        linkedList.addNode(new LinkedListNode(5));
        linkedList.addNode(new LinkedListNode(3));
        linkedList.addNode(new LinkedListNode(1));
        linkedList.addNode(new LinkedListNode(2));
        linkedList.addNode(new LinkedListNode(4));
        linkedList.addNode(new LinkedListNode(6));

        System.out.println(linkedList);

        System.out.println("Mid: " + LinkedListAlgo.getMiddle(linkedList));
    }
}

