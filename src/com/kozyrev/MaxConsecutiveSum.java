package com.kozyrev;

/**
 * Created by sergii on 9/15/16.
 */
public class MaxConsecutiveSum {

    public static void main(String[] args){
        System.out.println(maxConsecutiveSum(new int[]{1,2,3,-7,10,11,-3}));//22
        System.out.println(maxConsecutiveSum(new int[]{1,2,3,-5,10,11,-3}));//21
    }

    public static int maxConsecutiveSum(int[] array) {
        int sum = 0;
        int max_ends_here = 0;
        for (int a : array) {
            max_ends_here = max(0, max_ends_here + a);
            sum = max(sum, max_ends_here);
        }
        return sum;
    }

    private static int max(int a, int b) {
        if (a>b) {
            return a;
        } else {
            return b;
        }

    }
}
