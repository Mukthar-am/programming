package com.muks.java.dsc.linkedlist;

public class LinkedList {
    public LinkedListNode Head;
    public LinkedListNode Tail;

    public LinkedList() {
        this.Head = null;
        this.Tail = null;
    }

    public LinkedList addNode(LinkedListNode node) {
        if (this.Head == null) {
            this.Head = this.Tail = node;
        }

        LinkedListNode n = this.Head;
        this.Tail.Next = node;
        this.Tail = node;

        return this;
    }

    public LinkedListNode getTail() {
        LinkedListNode node = this.Head;
        while (node.Next != null) {
            node = node.Next;
        }

        return node;
    }


    // Helper function to print a given linked list
    public static void printList(LinkedListNode head) {
        LinkedListNode ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.Value + " —> ");
            ptr = ptr.Next;
        }

        System.out.println("null");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (this.Head == null)
            return "{}";

        LinkedListNode node = this.Head;


        while (node != null) {
            sb.append(node.Value);
            if (node.Next != null)
                sb.append(", ");

            node = node.Next;
        }
        sb.append("}");

        return sb.toString();
    }
}
