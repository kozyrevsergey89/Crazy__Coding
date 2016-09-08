package com.kozyrev.datastructures;

/**
 * Created by sergii on 9/8/16.
 */
public class MyStack<E> {

    private Node top;
    public int size = 0;

    public void push(E e) {
        size++;
        if (top==null) {
            top = new Node(e);
        } else {
            Node temp = new Node(e);
            temp.setNext(top);
            top = temp;
        }
    }

    public E pop() {
        size--;
        if (top == null) {
            return null;
        } else {
            E item = (E) top.value;
            top = top.next;
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
