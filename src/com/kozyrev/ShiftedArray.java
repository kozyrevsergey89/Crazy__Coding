package com.kozyrev;

/**
 * Created by sergii on 9/15/16.
 */
public class ShiftedArray {

    public static void main(String[] args){
        System.out.println(findShiftedPosition(new int[]{7,8,9,1,2,3,4,5,6}));
    }

    public static int findShiftedPosition(int[] array) {
        return findShiftedPosition(array, 0, array.length - 1);
    }

    private static int findShiftedPosition(int[] array, int start, int end) {
        int middle = (end - start) / 2;
        if (start == end || end - start == 1) {
            return start;
        } else if (array[start + middle] < array[start]) {
            return findShiftedPosition(array, start, start + middle);
        } else if (array[start + middle] > array[end]) {
            return findShiftedPosition(array, start + middle, end);
        }
        return 0;

    }
}
