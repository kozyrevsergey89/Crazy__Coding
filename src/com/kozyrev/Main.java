package com.kozyrev;

import com.kozyrev.datastructures.MyArrayQueue;
import com.kozyrev.datastructures.MyArrayStack;
import com.kozyrev.datastructures.MyQueue;
import com.kozyrev.datastructures.MyStack;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        testQueue();
//        testStack();
//        testArrayStack();
        testArrayQueue();
    }

    private static void testArrayQueue() {
        MyArrayQueue<Integer> queue= new MyArrayQueue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        while (queue.size() > 0) {
            System.out.print(queue.dequeue());
            System.out.println();
        }
    }

    private static void testArrayStack() {
        MyArrayStack<Integer> stack = new MyArrayStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        while (stack.size() > 0) {
            System.out.print(stack.pop());
            System.out.println();
        }
    }

    private static void testQueue() {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        while (queue.size > 0) {
            System.out.print(queue.dequeue());
            System.out.println();
        }
    }

    private static void testStack() {
        MyStack<Integer> stack = new MyStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        while (stack.size > 0) {
            System.out.print(stack.pop());
            System.out.println();
        }
    }
}
