package com.kozyrev.graphs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by sergii on 9/13/16.
 */
public class TraverseByLevels {

    private static class Node {
        Node(int value) {
            this.value = value;
        }

        int value;
        Node left;
        Node right;

        @Override
        public String toString() {
            return "" + value;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(22);
        root.right = new Node(33);

        root.left.left = new Node(444);
        root.left.right = new Node(555);

        root.right.left = new Node(666);
        root.right.right = new Node(777);

//        traverseByLevels(root);

        traverseFromBottomToTop(root);
    }

    private static void traverseByLevels(Node root) {
        int level = 0;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        int k = 0;
        while (!queue.isEmpty()) {

            Node node = queue.remove();
            System.out.print("" + node + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.left != null) {
                queue.add(node.right);
            }

            if (k == level * 2) { // filled the level
                System.out.print(" - current level is " + level++);
                System.out.println();
                k = 0;
            }
            k++;
        }
    }

    private static void traverseFromBottomToTop(Node root) {
        Stack<Node> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int k = 0;
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            stack.push(node);
            k++;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        while (!stack.isEmpty()) {

            System.out.print(stack.pop() + " ");
            int checker = (k & (k - 1));
            if (checker == 0) {
                System.out.print("  - current level is " + k / 2);
                System.out.println();
            }
            k--;
        }

    }
}
