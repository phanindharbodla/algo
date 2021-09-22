package com.algo;

public class test {
    static SinglyLinkedListNode sort(int k, SinglyLinkedListNode head) {
        if (head == null)
            return null;

        SinglyLinkedListNode current = head;
        SinglyLinkedListNode next = null;
        int count = 1;

        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        if (current != null) {
            next = current.next;
            current.next = null;
        } else
            next = null;

        head = mergeSort(head);

        SinglyLinkedListNode end = head;
        while (end != null && end.next != null) {
            end = end.next;
        }

        if (end != null)
            end.next = sort(k, next);

        return head;
    }

    static SinglyLinkedListNode combine(SinglyLinkedListNode a, SinglyLinkedListNode b) {
        SinglyLinkedListNode result = null;
        if (a == null)
            return b;
        if (b == null)
            return a;

        if (a.data <= b.data) {
            result = a;
            result.next = combine(a.next, b);
        } else {
            result = b;
            result.next = combine(a, b.next);
        }
        return result;

    }

    static SinglyLinkedListNode mergeSort(SinglyLinkedListNode h) {
        if (h == null || h.next == null) {
            return h;
        }

        SinglyLinkedListNode middle = getMiddle(h);
        SinglyLinkedListNode nextofmiddle = middle.next;


        middle.next = null;


        SinglyLinkedListNode left = mergeSort(h);


        SinglyLinkedListNode right = mergeSort(nextofmiddle);


        SinglyLinkedListNode sortedlist = combine(left, right);
        return sortedlist;
    }

    static SinglyLinkedListNode getMiddle(SinglyLinkedListNode h) {

        if (h == null)
            return h;
        SinglyLinkedListNode two = h.next;
        SinglyLinkedListNode one = h;

        while (two != null) {
            two = two.next;
            if (two != null) {
                one = one.next;
                two = two.next;
            }
        }
        return one;
    }


}