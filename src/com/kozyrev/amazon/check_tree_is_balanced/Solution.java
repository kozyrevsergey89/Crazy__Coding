package com.kozyrev.amazon.check_tree_is_balanced;


class Solution {

    public static void main(String[] args) {
        Node root = new Node();
        Node root1 = new Node();
        Node root2 = new Node();
        Node root3 = new Node();
        Node root4 = new Node();
        Node root5 = new Node();
        Node root6 = new Node();
        Node root7 = new Node();
        Node root8 = new Node();
        Node root9 = new Node();

        root.left=root1;
        root.right=root2;
        root1.left = root3;
        root1.right= root4;
        root2.left = root5;
        root2.right= root6;
//        root6.left=root7;
//        root7.left=root8;
//        root8.left=root9;


        System.out.println(isBalanced(root));
    }

    private static class Node {
        Node left;
        Node right;
    }

    public static boolean isBalanced(Node n) {
        if (n == null) return true;
        int leftHeigh = isBalancedHeight(n.left);
        int rightHeigh = isBalancedHeight(n.right);
        if (leftHeigh < 0 || rightHeigh < 0 || Math.abs(leftHeigh - rightHeigh) > 1) {
            return false;
        } else {
            return true;
        }
    }

    private static int isBalancedHeight(Node n) {
        if (n == null) return 0;
        int leftHeigh = isBalancedHeight(n.left);
        int rightHeigh = isBalancedHeight(n.right);
        if (leftHeigh < 0 || rightHeigh < 0 || Math.max(leftHeigh, rightHeigh) > 1) {
            return -1;
        } else {
            return Math.max(leftHeigh, rightHeigh) + 1;
        }
    }

}
