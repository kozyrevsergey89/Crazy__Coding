package com.kozyrev;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sergii on 3/18/17.
 */
public class BinaryTreeSerializer {

    public static Integer[] serialize(Node root) {
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            list.add(node.val);
            if (node.val != Integer.MIN_VALUE) {
                if (node.left == null) {
                    queue.add(new Node());
                } else {
                    queue.add(node.left);
                }

                if (node.right == null) {
                    queue.add(new Node());
                } else {
                    queue.add(node.right);
                }
            }

        }
        return list.toArray(new Integer[list.size()]);
    }

    public static Node deserialize(Integer[] arr) {
        Node root = new Node();
        root.val = arr[0];
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        int i=1;
        while (i<arr.length){
            Node node = queue.remove();
            //left
            if (arr[i]!=Integer.MIN_VALUE){
                Node left = new Node();
                left.val = arr[i];
                node.left=left;
                queue.add(left);
            }
            //right
            if (arr[i+1]!=Integer.MIN_VALUE){
                Node right = new Node();
                right.val = arr[i+1];
                node.right=right;
                queue.add(right);
            }
            i+=2;
        }
        return root;
    }

    public static class Node {
        public Node left = null;
        public Node right = null;
        public Integer val = Integer.MIN_VALUE; // we use min value as null terminator here

        @Override
        public String toString() {
            return "" + val;
        }
    }

    public static void traverseFromTopToBottom(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int counter = 1;
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            System.out.print(" " + n.val + " ");
            counter++;
            boolean checker = ((counter & (counter - 1)) == 0);
            if (checker) System.out.print("\n");
            if (n.left != null) queue.add(n.left);
            if (n.right != null) queue.add(n.right);
        }
    }
}
