package com.kozyrev.badoo;

import java.util.*;

public class Solution {

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for (int arr_i = 0; arr_i < 5; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        int sum = 0;
        for (int i : arr) {
            sum += i;

        }
        System.out.println(sum);
    }

    static String[] braces2(String[] values) {
        if (values == null || values.length == 0) return null;

        Stack<Character> stack = new Stack<>();
        final String YES = "YES";
        final String NO = "NO";
        String[] results = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            String s = values[i];
            stack.clear();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '(' || c == '[' || c == '{') {
                    stack.add(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        results[i] = NO;
                        break;
                    }
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        results[i] = NO;
                        break;
                    }
                } else if (c == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        results[i] = NO;
                        break;
                    }
                }
            }
            results[i] = (stack.isEmpty()) ? YES : NO;
        }
        return results;
    }

    static String[] braces(String[] values) {
        if (values == null || values.length == 0) return null;

        int roundStackCounter;
        int curlyStackCounter;
        int squareStackCounter;
        final String YES = "YES";
        final String NO = "NO";
        String[] results = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            String s = values[i];
            roundStackCounter = 0;
            curlyStackCounter = 0;
            squareStackCounter = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    roundStackCounter++;
                } else if (s.charAt(j) == '[') {
                    squareStackCounter++;
                } else if (s.charAt(j) == '{') {
                    curlyStackCounter++;
                } else if (s.charAt(j) == ')') {
                    roundStackCounter--;
                } else if (s.charAt(j) == ']') {
                    squareStackCounter--;
                } else if (s.charAt(j) == '}') {
                    curlyStackCounter--;
                }
            }
            results[i] = (roundStackCounter == 0 && curlyStackCounter == 0 && squareStackCounter == 0) ? YES : NO;
        }
        return results;
    }

    static class MyPair {
        MyPair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int hashCode() {


            return getStringRepresentation(this).hashCode();
        }

        static String getStringRepresentation(MyPair pair){
            return String.valueOf((pair.first > pair.second) ? pair.second : pair.first) +
                    ((pair.first < pair.second) ? pair.second : pair.first);
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof MyPair && getStringRepresentation(this).equals(getStringRepresentation((MyPair) obj));
        }

        int first;
        int second;


    }

    static int numberOfPairs(int[] a, long k) {
        Set<MyPair> results = new HashSet<>();
        Arrays.sort(a); // sort the array takes nlog(n) time
        int i=0; int j = a.length-1;
        while (i<j) {
            long sum = a[i] + a[j];
            if (sum == k) {
                results.add(new MyPair(a[i], a[j]));
                i++;
            } else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }
        return results.size();
    }


    public static void main(String[] args) {


        String[] strings = new String[]{
                "7",
                "1100001",
                "1110001",
                "0110001",
                "0001100",
                "0001100",
                "0000010",
                "0010001"

        };

        int count = zombieCluster(strings);
        System.out.println(count);
    }

    /**
     *
     *
     * 4
     * 1111
     * 1001
     * 0011
     * 1100
     */
    static int zombieCluster(String[] zombies) {

        int size = Integer.parseInt(zombies[0]);

        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.parseInt(zombies[i + 1].charAt(j) + ""); // StringOutofBound exception 4
            }
        }

        boolean visited[] = new boolean[size];
        boolean visiting[] = new boolean[size];

        int count = 0;
        for (int i = 0; i < size; ++i) {
            if (!visited[i]) {
                visiting[i] = true;
                depthFirstSearch(matrix, size, visited, visiting, i);
                visited[i] = true;
                count++;
            }
        }
        return count;
    }

    static void depthFirstSearch(int matrix[][], int size, boolean visited[], boolean[] visiting, int s) {
        if (!visited[s]) {
            visiting[s] = true;
            for (int j = s + 1; j < size; j++) {
                if (matrix[s][j] == 1 && !visited[j]) {
                    visiting[j] = true;
                    depthFirstSearch(matrix, size, visited, visiting, j);
                    visited[j] = true;
                }
            }
        }
    }
}