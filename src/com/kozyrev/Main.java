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
//        testArrayQueue();
        testBinaryTreeSerializer();
    }

    private static void testBinaryTreeSerializer() {
        BinaryTreeSerializer.Node root = new BinaryTreeSerializer.Node();
        root.val = 777;
        BinaryTreeSerializer.Node node = root;
        int i = 0;
        while (i<10) {

            BinaryTreeSerializer.Node node1 = new BinaryTreeSerializer.Node();
            node1.val = i++;
            node.left=node1;

            BinaryTreeSerializer.Node node2 = new BinaryTreeSerializer.Node();
            node2.val = i++;
            node.right=node2;

            if (i%4==0){
                node=node.right;
            } else {
                node=node.left;
            }
        }

        System.out.println("testBinaryTreeSerializer"+root.val);
        BinaryTreeSerializer.traverseFromTopToBottom(root);

        Integer[] array = BinaryTreeSerializer.serialize(root);
        System.out.println("array form start");
        for (int number : array){
            System.out.println(""+number);
        }
        System.out.println("array form finish");

        System.out.println("Node form again!!!");
        BinaryTreeSerializer.Node deserialized = BinaryTreeSerializer.deserialize(array);
        System.out.println(""+deserialized);
        BinaryTreeSerializer.traverseFromTopToBottom(deserialized);
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
