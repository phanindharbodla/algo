package com.algo;

public class ListSort {
    public static void main(String args[]) {
        SinglyLinkedListNode head = new SinglyLinkedListNode(0);
        SinglyLinkedListNode temp = head;
        int i = 23;
        while (i > 1) {
            temp.next = new SinglyLinkedListNode(--i);
            temp = temp.next;
        }
        printList(head);
        head = sort(70, head);
        System.out.println();
        printList(head);
    }

    private static SinglyLinkedListNode sort(int k, SinglyLinkedListNode list) {

        int i = 0, c = k;

        SinglyLinkedListNode parent = null, prevTail = null, cur, NextHead = list;
        SinglyLinkedListNode temp = list;
        while (NextHead != null) {
            i = 1;
            cur = NextHead;
            while (i != k && NextHead != null) {
                i++;
                //c--;
                if (NextHead.next != null)
                    NextHead = NextHead.next;
            }
            temp = NextHead.next;
            NextHead.next = null;
            NextHead = temp;
            cur = sortList(cur);
            temp = cur;
            if (parent == null)
                parent = cur;
            else
                prevTail.next = cur;
            while (temp.next != null) {
                temp = temp.next;
            }
            prevTail = temp;
        }
        return parent;

    }

    private static SinglyLinkedListNode sortList(SinglyLinkedListNode head) {
        if (head == null || head.next == null) return head;
        if (head.next.next == null) {
            int min = Math.min(head.data, head.next.data);
            int max = Math.max(head.data, head.next.data);
            head.data = min;
            head.next.data = max;
            return head;
        }
        SinglyLinkedListNode firstHalf = head;
        SinglyLinkedListNode secondHalf = head.next;
        while (secondHalf != null && secondHalf.next != null) {
            secondHalf = secondHalf.next.next;
            firstHalf = firstHalf.next;
        }
        secondHalf = firstHalf.next;
        firstHalf.next = null;
        firstHalf = head;
        firstHalf = sortList(firstHalf);
        secondHalf = sortList(secondHalf);
        return mergeLists(firstHalf, secondHalf);
    }

    private static SinglyLinkedListNode mergeLists(SinglyLinkedListNode firstHalf, SinglyLinkedListNode secondHalf) {
        SinglyLinkedListNode head, temp;
        if (firstHalf.data < secondHalf.data) {
            head = firstHalf;
            firstHalf = firstHalf.next;
            head.next = null;
        } else {
            head = secondHalf;
            secondHalf = secondHalf.next;
            head.next = null;
        }
        temp = head;
        boolean notnull = true;
        while (firstHalf != null || secondHalf != null) {
            if (firstHalf == null) {
                head.next = secondHalf;
                secondHalf = null;
                notnull = false;
            }
            if (secondHalf == null) {
                head.next = firstHalf;
                firstHalf = null;
                notnull = false;
            }
            if (notnull) {
                if (firstHalf.data < secondHalf.data) {
                    head.next = firstHalf;
                    firstHalf = firstHalf.next;
                } else {
                    head.next = secondHalf;
                    secondHalf = secondHalf.next;
                }
                head = head.next;
                head.next = null;
            }
        }
        return temp;
    }

    private static void printList(SinglyLinkedListNode head) {
        SinglyLinkedListNode node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}