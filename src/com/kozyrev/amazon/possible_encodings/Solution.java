package com.kozyrev.amazon.possible_encodings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by skozyrev on 11/4/17.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println("" + possibleEncodings("127651287312853182"));

        List<String> input = new ArrayList<>();
        input.add("Natali");
        input.add("Sergii");
        input.add("Barbosik");
        input.add("MishonokBo");
        for (List<String> list : superList(input)) {
            System.out.println("");
            for (String s: list) {
                System.out.print(s + " ");
            }
        }

    }

    public static int possibleEncodings(String s) {
        return possibleEncodings(s, 0);
    }

    private static int possibleEncodings(String s, int i) {
        if (i == s.length() - 1) {
            return 1;
        } else if (i < s.length() - 1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && isFromZeroToFive(s.charAt(i + 1))))) {
            return possibleEncodings(s, i + 1) + possibleEncodings(s, i + 2);
        } else {
            return possibleEncodings(s, i + 1);
        }
    }

    private static boolean isFromZeroToFive(char c) {
        return c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5';
    }

    public static List<List<String>> superList(List<String> strings) {
        if (strings.size() == 0) {
            return Collections.singletonList(strings);
        } else {
            String first = strings.get(0);
            List<List<String>> temp = new ArrayList<>();
            for (List<String> list : superList(strings.subList(1, strings.size()))) {
                List<String> withFirst = new ArrayList<>();
                withFirst.add(first);
                withFirst.addAll(list);
                temp.add(list);
                temp.add(withFirst);
            }
            return temp;
        }
    }


}
