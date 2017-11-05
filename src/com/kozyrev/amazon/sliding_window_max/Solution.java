package com.kozyrev.amazon.sliding_window_max;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public static void main(String[] args) {
        int[] a = new int[]{1,2,4, 44,55,56,100,101,122};
        for (Integer i :
                maxSlidingWindow(a, 3)) {
            System.out.println(i);
        }
        System.out.println("-------");
        for (Integer i :
                maxSlidingWindowLinear(a, 3)) {
            System.out.println(i);
        }
    }




    public static int[] maxSlidingWindowLinear(int[] nums, int k) {

        int N = nums.length;
        int ri = 0;
        int[] res = new int[N - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=0; i<nums.length; i++) {
            while(!deque.isEmpty() && deque.peek() < i-k+1) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()]< nums[i]){
                deque.pollLast();
            }

            deque.offer(i);
            if (i>=k-1){
                res[ri++]= nums[deque.peek()];
            }
        }
        return res;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int N = nums.length;
        int dif = N - k;
        int i = 0;
        int[] res = new int[N - k + 1];
        while (i <= dif) {
            int max = findMax(nums, i, k);
            res[i] = max;
            i++;
        }
        return res;
    }

    private static int findMax(int[] nums, int i, int k) {
        int j = 1;
        int max = nums[i];
        while (j < k) {
            if (nums[i+j] > max) max = nums[i+j];
            j++;
        }
        return max;
    }
}
