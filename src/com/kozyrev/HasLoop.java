package com.kozyrev;

/**
 * Created by sergii on 9/15/16.
 */

import java.util.*;


class HasLoop {
    public static void main(String[] args) {
//        System.out.println("first case sos: " + isPalindrome("sos"));
//        System.out.println("first case soa: " + isPalindrome("soa"));

        System.out.println("match: foobar and foobar: " + isMatch("fooooooooobar", "foo*ba."));


        int[][] matrix = new int[][] {
                {3, 2, 1,11},
                {7, 8, 9,12},
                {6, 5, 4,13},
                {61, 51, 41,131}
        };
        for (int i =0; i<matrix.length;i++){
            System.out.println();
            for(int j=0; j<matrix.length;j++) {
                System.out.print(" "+matrix[i][j]);
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();

//        int[][] rotated = rotateOuterRingMatrix(matrix);
//        for (int i =0; i<rotated.length;i++){
//            System.out.println();
//            for(int j=0; j<rotated.length;j++) {
//                System.out.print(rotated[i][j]);
//            }
//        }

        System.out.println();
        System.out.println();
        System.out.println();

        int[][] rotated2 = rotateMatrix(matrix, matrix.length);
        for (int i =0; i<rotated2.length;i++){
            System.out.println();
            for(int j=0; j<rotated2.length;j++) {
                System.out.print(" "+rotated2[i][j]);
            }
        }
    }

    static boolean hasLoop(Node node) {
        if (node == null) {
            return false;
        }
        Node slow = node;
        Node fast = node;
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }

        }
        return false;
    }


    private static boolean isPalindrome(String s) {

        int end = s.length() - 1;
        int start = 0;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            } else {
                start = start + 1;
                end = end - 1;
            }
        }
        return true;
    }

    static int[][] rotateMatrix(int[][] matrix, int n) {
        int[][] ret = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                ret[i][j] = matrix[n - j - 1][i];
            }
        }
        return ret;
    }

    static int[][] rotateMatrixInPlace(int[][] matrix, int n) {
        for (int i = 0; i < n / 2; ++i) {
            int d = n - 2 * i;
            for (int j = i; j < d; ++j) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[d - 1 - j][i];
                matrix[d - 1 - j][i] = matrix[d - 1 - j][d - 1 - i];
                matrix[d - 1 - j][d - 1 - i] = matrix[j][d - 1 - i];
                matrix[j][d - 1 - i] = temp;
            }
        }
        return matrix;
    }

    public static boolean matchingPattern(String s, String p) {
        if (s == null || p == null) return false;
        return matchingPattern(s, p, 0, 0);
    }

    public static boolean matchingPattern(String s, String p, int i, int pi) {
        if (i == s.length() - 1 && pi == p.length() - 1) {
            return true;
        } else if (i >= s.length() || pi >= p.length()) {
            return false;
        }
        if (pi + 1 < p.length() && p.charAt(pi + 1) != '*') {
            return s.charAt(i) == p.charAt(pi) && matchingPattern(s, p, ++i, ++pi);
        } else {
            while (s.charAt(i) == p.charAt(pi) || (p.charAt(pi) == '.' && i < s.length())) {
                if (matchingPattern(s, p, i, pi + 2)) return true;
                i++;
            }
        }
        return matchingPattern(s, p, i, pi + 2);
    }

//    void rotate(T (&matrix)[dim][dim])
//    {
//        const size_t d = dim-1;
//        for (size_t y = 0; y < dim/2; ++y)
//        {
//            for (size_t x = y; x < d-y; ++x)
//            {
//                swap(matrix[y  ][x  ],
//                        matrix[x  ][d-y],
//                        matrix[d-y][d-x],
//                        matrix[d-x][y  ]);
//            }
//        }
//    }


    static boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        return isMatch(s, p, 0, 0);
    }

    static boolean isMatch(String s, String p, int i, int pi) {
        if (i == s.length() - 1 && pi == p.length() - 1) {
            return true;
        } else if (i >= s.length() || pi >= p.length()) {
            return false;
        }
        if (pi + 1 < p.length() && p.charAt(pi + 1) != '*') {
            return (p.charAt(pi) == s.charAt(i)) && isMatch(s, p, ++i, ++pi);
        } else {
            while ((p.charAt(pi) == s.charAt(i)) || (p.charAt(pi) == '.' && i < s.length())) {
                if (isMatch(s, p, i, pi + 2)) return true;
                i++;
            }
        }
        return isMatch(s, p, i, pi + 2);
    }


    void colorBucket(int[][] screen, int fillColor, int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        int firstColor = screen[x][y];
        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point p = queue.remove();
            if ((y + 1 < screen[0].length) && screen[p.x][p.y + 1] == firstColor) {
                queue.add(new Point(x, y + 1));
            }
            if ((x + 1 < screen.length) && screen[p.x + 1][p.y] == firstColor) {
                queue.add(new Point(x + 1, y));
            }
            if ((y - 1 >= 0) && screen[p.x][p.y - 1] == firstColor) {
                queue.add(new Point(x, y - 1));
            }
            if ((x - 1 >= 0) && screen[p.x - 1][p.y] == firstColor) {
                queue.add(new Point(x - 1, y));
            }
            screen[p.x][p.y] = fillColor;

        }
    }


    static void fillColor(int[][] img, int x, int y, int color) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point p = queue.remove();
            if (y < img.length && img[x][y + 1] == img[x][y]) queue.add(new Point(x, y + 1));//check out of bounds
            if (img[x][y - 1] == img[x][y]) queue.add(new Point(x, y - 1));
            if (x < img.length && img[x + 1][y] == img[x][y]) queue.add(new Point(x + 1, y));//check out of bounds
            if (img[x - 1][y] == img[x][y]) queue.add(new Point(x - 1, y));
            img[p.x][p.y] = color;
        }
    }

    static class Point {
        int x;
        int y;
//        int color;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
//            this.color=color;
        }
    }

    static boolean isUniqueCharacters(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int checker = 0;
        for (char c : s.toCharArray()) {
            int charPos = c - 'a';
            if ((checker & (1 << charPos)) != 0) return false;
            checker = checker | (1 << charPos);
        }
        return true;
    }

    private static Node makeFlattenLinkedList(Node root) {
        Node node = root;
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            if (node.next != null) {
                stack.push(node.next);
            }
            if (node.value != null) {
                insert(node.value, node);
                stack.push(node.value);
            }
        }
        return root;
    }


    private static void insert(Node what, Node after) {
        Node temp = after.next;
        after.next = what;
        what.next = temp;
    }

    static class Node {
        Node next;
        Node value;
    }
}
