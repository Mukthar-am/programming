package com.muks.java.dsc.linkedlist;

public class LinkedListAlgo {

    public static LinkedListNode getMiddle(LinkedList linkedList) {
        LinkedListNode fastPointer = linkedList.Head;
        LinkedListNode slowPointer = linkedList.Head;

        while (fastPointer.next != null && fastPointer.next.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }

        return slowPointer;
    }
}
