package com.kozyrev.amazon.median_of_two_arrays;

/**
 * Created by skozyrev on 11/4/17.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(""+ findMedian(new int[]{1,2,4, 44,55,56,100,101,122}, new int[]{1,2,3,4,5}));
    }

    public static int findMedian(int[] a1, int[] a2) {
        int[] m = new int[a1.length + a2.length];
        int i = 0;
        int j = 0;
        int mi = 0;
        while (i < a1.length && j < a2.length) {//TODO
            if (a1[i] < a2[j]) {
                m[mi] = a1[i];
                i++;
            } else {
                m[mi] = a2[j];
                j++;
            }
            mi++;
        }
        if (j >= a2.length) {
            while (i < a1.length) {
                m[mi++] = a1[i++];
            }
        }

        if (i >= a1.length) {
            while (j < a2.length) {
                m[mi++] = a2[j++];
            }
        }
        return findMedianOfAnArray(m);

    }

    private static int findMedianOfAnArray(int[] m) {
        if (m.length % 2 == 0) {
            return (m[m.length / 2] + m[m.length / 2 + 1]) / 2;
        } else {
            return m[m.length / 2];
        }
    }
}
