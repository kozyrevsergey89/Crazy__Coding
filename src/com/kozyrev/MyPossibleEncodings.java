package com.kozyrev;

import java.util.Stack;

/**
 * Created by sergii on 10/13/16.
 */
public class MyPossibleEncodings {

    public static void main(String[] args) {
        System.out.println(""+possibleEncodings(new int[]{1,2}));
    }

    public static int possibleEncodings(int[] numbers){
//        return possibleEncodings(numbers, numbers.length);
        return possiblesolutionsIterative(numbers);
    }

    private static int possibleEncodings(int[] numbers, int length) {
        if (length==0 || length==1){
            return 1;
        }
        int count = possibleEncodings(numbers, length-1);
        if (numbers[length-2]==1 || (numbers[length-2]==2 && numbers[length-1]<7)){
            count+=possibleEncodings(numbers, length-2);
        }
        return count;
    }

    static int possiblesolutionsIterative(int[] numbers) {
        if (numbers.length==0 || numbers.length==1){
            return 1;
        }
        int count = 0;

        Stack<Integer> stack = new Stack<>();
        stack.add(0);
//        count--;
        while(!stack.isEmpty()) {
            int shift = stack.pop();
            count++;
            if (shift+1< numbers.length){
//                count++;
                stack.push(shift+1);
            }
            if ((shift+2 < numbers.length) && (numbers[shift+1]==1 || (numbers[shift+1]==2 && numbers[shift+2]<7))){
//                count++;
                stack.push(shift+2);
            }
        }

        return count;
    }
}
