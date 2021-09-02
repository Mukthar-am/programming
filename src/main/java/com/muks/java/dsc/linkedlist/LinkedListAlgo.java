package com.muks.java.dsc.linkedlist;

import java.util.Arrays;

public class LinkedListAlgo {

    public static LinkedListNode getMiddle(LinkedList linkedList) {
        LinkedListNode fastPointer = linkedList.Head;
        LinkedListNode slowPointer = linkedList.Head;

        while (fastPointer.Next != null && fastPointer.Next.Next != null) {
            fastPointer = fastPointer.Next.Next;
            slowPointer = slowPointer.Next;
        }

        return slowPointer;
    }








    /** merge sort linked list
        Takes two lists sorted in increasing order and merge their nodes
        to make one big sorted list, which is returned
     */
    public static LinkedListNode sortedMerge(LinkedListNode a, LinkedListNode b) {
        // base cases
        if (a == null) {
            return b;
        }
        else if (b == null) {
            return a;
        }

        LinkedListNode result;

        // pick either `a` or `b`, and recur
        if ((Integer) a.Value <= (Integer) b.Value)
        {
            result = a;
            result.Next = sortedMerge(a.Next, b);
        }
        else {
            result = b;
            result.Next = sortedMerge(a, b.Next);
        }

        return result;
    }


    /**
        Split the given list's nodes into front and back halves,
        If the length is odd, the extra node should go in the front list.
        It uses the fast/slow pointer strategy
    */
    public static LinkedListNode[] frontBackSplit(LinkedListNode source)
    {
        // if the length is less than 2, handle it separately
        if (source == null || source.Next == null) {
            return new LinkedListNode[]{ source, null };
        }

        LinkedListNode slow = source;
        LinkedListNode fast = source.Next;

        // advance `fast` two nodes, and advance `slow` one node
        while (fast != null)
        {
            fast = fast.Next;
            if (fast != null)
            {
                slow = slow.Next;
                fast = fast.Next;
            }
        }

        // `slow` is before the midpoint in the list, so split it in two
        // at that point.
        LinkedListNode[] arr = new LinkedListNode[]{ source, slow.Next };
        slow.Next = null;

        return arr;
    }

    // Sort a given linked list using the merge sort algorithm
    public static LinkedListNode mergesort(LinkedListNode head) {
        // base case — length 0 or 1
        if (head == null || head.Next == null)
            return head;

        // split `head` into `a` and `b` sublists
        LinkedListNode[] arr = frontBackSplit(head);
        System.out.println(Arrays.stream(arr).toArray().toString());
        LinkedListNode front = arr[0];
        LinkedListNode back = arr[1];

        // recursively sort the sublists
        front = mergesort(front);
        back = mergesort(back);

        // answer = merge the two sorted lists
        return sortedMerge(front, back);
    }






}
