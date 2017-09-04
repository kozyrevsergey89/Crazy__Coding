package com.kozyrev.datastructures;

import java.util.*;

/**
 * Created by skozyrev on 9/4/17.
 */

/**
 * ready to go
 *
 * serialize and deserialize binary tree
 */
public class TreeSerializer {

    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n2 = new Node(2, null, null);
        Node n3 = new Node(3, null, null);
        Node n4 = new Node(4, null, null);
        Node n5 = new Node(5, null, null);
        Node n6 = new Node(6, null, null);
        Node n7 = new Node(7, null, null);
        Node n8 = new Node(8, null, null);
        Node n9 = new Node(9, null, null);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;
        System.out.println("tree is ready" + n1);
        Integer[] serialized = serialize(n1);
        System.out.println("array is ready:" + Arrays.toString(serialized));
        Node root = deSerialize(serialized);
        System.out.println("tree is deserialized" + root);

    }

    public static Integer[] serialize(Node n) {
        if (n == null) return null;
        Queue<Node> q = new LinkedList<>();
        List<Integer> integerList = new ArrayList<>();
        q.add(n);
        while (!q.isEmpty()) {
            Node node = q.remove();
            if (node == null) {
                integerList.add(null);
            } else {
                integerList.add(node.val);
                q.add(node.left);
                q.add(node.right);
            }
        }
        return integerList.toArray(new Integer[integerList.size()]);
    }

    public static Node deSerialize(Integer[] ar) {
        if (ar == null || ar.length == 0) return null;
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(ar[0], null, null);
        q.add(root);
        int i = 0;
        while (i < ar.length && !q.isEmpty()) {

            Node node = q.remove();
            while ((node == null || node.val == null) && !q.isEmpty()) {
                node = q.remove();
            }

            if (i < ar.length - 1) {
                Integer valL = ar[++i];
                Node nodeLeft = null;
                if (valL !=null) {
                    nodeLeft = new Node(valL, null, null);
                    node.left = nodeLeft;
                }
                q.add(nodeLeft);
            }

            if (i < ar.length - 1) {
                Integer valR = ar[++i];
                Node nodeRight = null;
                if (valR!=null) {
                    nodeRight = new Node(valR, null, null);
                    node.right = nodeRight;
                }

                q.add(nodeRight);
            }


        }
        return root;
    }

    public static class Node {
        public Integer val;
        public Node left;
        public Node right;

        public Node(Integer val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return " " + val + " , " + (left != null ? left.toString() : "empty") + (right != null ? right.toString() : "empty");
        }
    }
}
