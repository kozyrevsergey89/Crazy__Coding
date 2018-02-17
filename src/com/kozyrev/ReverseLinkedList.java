package com.kozyrev;

/**
 * Created by sergii on 10/13/16.
 */
public class ReverseLinkedList {
    static class Node {
        Node next;
    }

    static Node kthFromEnd(Node root, int k) {
        if (root==null) {return null;}
        Node node = root;
        Node run = root;
        int i=0;
        while (i<k){
            node=node.next;
            if (node==null) {return null;}
        }

        while(node.next!=null) {
            run=run.next;
            node=node.next;
        }
        return run;

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


    public static Node reverse(Node node) {
        Node current = node;
        Node prev = null;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        return prev;
    }


}
