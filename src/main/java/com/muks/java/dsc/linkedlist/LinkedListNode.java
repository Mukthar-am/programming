package com.muks.java.dsc.linkedlist;

public class LinkedListNode<T> {
    public Object value;
    public LinkedListNode next;

    public LinkedListNode(Object val) {
        this.value = val;
        this.next = null;
    }

    public String toString() {
        return "(" + this.value + ")";
    }
}
