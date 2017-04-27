package com.kozyrev;

/**
 * Created by sergii on 10/23/16.
 */
public class FibonachiProblem {

    public static void main(String[] args) {
        System.out.println("here we go: " + recursiveSolution(45));
        System.out.println("here we go: " + iterativeDinamicSolution(45));
    }

    public static int recursiveSolution(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return recursiveSolution(n - 1) + recursiveSolution(n - 2);
        }
    }

    public static long iterativeDinamicSolution(int n) {
        long[] res = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1) {
                res[i] = 1;
            } else {
                res[i] = res[i - 1] + res[i - 2];
            }
        }
        return res[n];
    }
}
