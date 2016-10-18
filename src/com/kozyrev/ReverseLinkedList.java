package com.kozyrev;

/**
 * Created by sergii on 10/13/16.
 */
public class ReverseLinkedList {
    static class Node {
        Node next;
    }

    static void reverseLinkedList(Node node) {
        Node prev = null;
        Node cur = node;
        Node next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
    }
}
