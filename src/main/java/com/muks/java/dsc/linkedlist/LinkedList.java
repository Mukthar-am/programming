package com.muks.java.dsc.linkedlist;

public class LinkedList {
    public LinkedListNode Head;
    public LinkedListNode Tail;

    public LinkedList() {
        this.Head = null;
        this.Tail = null;
    }

    public void addNode(LinkedListNode node) {
        if (this.Head == null) {
            this.Head = this.Tail = node;
            return;
        }

        LinkedListNode n = this.Head;
        this.Tail.next = node;
        this.Tail = node;
    }

    public LinkedListNode getTail() {
        LinkedListNode node = this.Head;
        while (node.next != null) {
            node = node.next;
        }

        return node;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (this.Head == null)
            return "{}";

        LinkedListNode node = this.Head;


        while (node != null) {
            sb.append(node.value);
            if (node.next != null)
                sb.append(", ");

            node = node.next;
        }
        sb.append("}");

        return sb.toString();
    }
}
