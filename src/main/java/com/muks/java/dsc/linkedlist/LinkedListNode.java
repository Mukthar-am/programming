package com.muks.java.dsc.linkedlist;

public class LinkedListNode<T> {
    public Object Value;
    public LinkedListNode Next;

    public LinkedListNode() {
        this.Value = null;
        this.Next = null;
    }

    public LinkedListNode(Object val) {
        this.Value = val;
        this.Next = null;
    }

    // Overriding equals() to compare two Complex objects
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof LinkedListNode))
            return false;
        if (obj == this)
            return true;
        return this.Value == ((LinkedListNode) obj).Value;
    }

//    @Override
//    public int hashCode() {
//        return (int) this.Value;
//    }

    public String toString() {
        return "(" + this.Value + ")";
    }
}
