package com.kozyrev.datastructures;

/**
 * Created by sergii on 9/8/16.
 */
public class MyQueue<E> {
    Node first;
    Node last;
    public int size = 0;

    public void enqueue(E e) {
        size++;
        if (first == null) {
            last = new Node(e);
            first = last;
        } else {
            Node temp = new Node(e);
            last.setNext(temp);
            last = temp;
        }
    }

    public E dequeue() {
        if (first==null) {
            return null;
        } else {
            size--;
            E item = (E) first.value;
            first = first.next;
            return item;
        }
    }

    private static class Node {
        private Object value;
        private Node next;
        public Node(Object o) {
            value = o;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
