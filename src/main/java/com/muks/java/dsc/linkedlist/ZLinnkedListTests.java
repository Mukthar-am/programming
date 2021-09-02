package com.muks.java.dsc.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.muks.java.dsc.linkedlist.LinkedListAlgo.mergesort;

public class ZLinnkedListTests {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.addNode(new LinkedListNode(5));
        linkedList.addNode(new LinkedListNode(3));
        linkedList.addNode(new LinkedListNode(1));
        linkedList.addNode(new LinkedListNode(2));
        linkedList.addNode(new LinkedListNode(4));
        linkedList.addNode(new LinkedListNode(6));

        //getMidElement(linkedList);

        sortedLinkedList(linkedList);
    }


    private static void getMidElement(LinkedList linkedList) {
        System.out.println(linkedList);
        System.out.println("Mid: " + LinkedListAlgo.getMiddle(linkedList));
    }


    public static void sortedLinkedList(LinkedList linkedList) {
        System.out.println("Linkedlist:- " + linkedList.toString());
        LinkedListNode sortedLinkedListHead = LinkedListAlgo.mergesort(linkedList.Head);
        LinkedList.printList(sortedLinkedListHead);


//        m1(linkedList.Head);
    }


    private static LinkedList m1(LinkedListNode node) {
        System.out.println("head:- " + node.toString());
        // base case — length 0 or 1
        if (node == null || node.Next == null) {
            return new LinkedList().addNode(node);
        }

        List<LinkedList> list = split(node);
        System.out.println("Lists: " + list);
        LinkedList front = list.get(0);
        LinkedList second = list.get(1);

        // recursively sort the sublists
        front = m1(front.Head);
        second = m1(second.Head);

        // answer = merge the two sorted lists
        //return sortedMerge(front, back);
        return null;
    }

    private static List<LinkedList> split(LinkedListNode head) {
        System.out.println("\n\n");
        LinkedList.printList(head);

        System.out.println("split by head:- "+ head);

        if (head == null || head.Next == null) {
            System.out.println("return...");
            return Arrays.asList(new LinkedList().addNode(head));
        }

        LinkedListNode node = head;
        LinkedListNode slow = head;
        LinkedListNode fast = head.Next;

        // advance `fast` two nodes, and advance `slow` one node
        while (fast != null)
        {
            System.out.println("runnings..." + slow + " " + fast);
            fast = fast.Next;
            if (fast != null) {
                slow = slow.Next;
                fast = fast.Next;
            }
        }

        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();

        while (!node.equals(slow.Next)) {
            LinkedListNode tmp = new LinkedListNode(node.Value);
            l1.addNode(tmp);

            node = node.Next;
        }

        while (node != null) {
            LinkedListNode tmp = new LinkedListNode(node.Value);
            l2.addNode(tmp);

            node = node.Next;
        }

        return Arrays.asList(l1, l2);
    }

}

