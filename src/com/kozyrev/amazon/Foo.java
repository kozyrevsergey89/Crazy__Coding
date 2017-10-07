///*
// * Complete the function below.
// */
//
//static int[] getMinimumDifference(String[] a, String[] b) {
//        int[] answer = new int[a.length];
//        for (int i=0; i<a.length; i++){
//        if (a[i].length() != b[i].length()) {
//        answer[i] = -1;
//        } else {
//        answer[i] = simbolsToAnagram(a[i], b[i]);
//        }
//
//        }
//        return answer;
//
//        }
//
//static int simbolsToAnagram(String a, String b){
//        int res = 0;
//        Map<Character, Integer> map = new HashMap<>(); // we hold all characters counts so it is still linear - N,
//        // and could be 2*N in worst case (if all characters different)
//        // where N is the length of one string
//        for(int i=0; i < a.length(); i++) { // we go through each character of both strings in on for loop
//        // so time complexity is linear and equal to N,
//        // where N is the length of one string
//        char ac = a.charAt(i);
//        char bc = b.charAt(i);
//        if (map.get(ac)==null){
//        map.put(ac, 1);
//        } else {
//        map.put(ac, map.get(ac)+1);
//        }
//
//        if (map.get(bc) == null){
//        map.put(bc, -1);
//        } else {
//        map.put(bc, map.get(bc) - 1);
//        }
//        }
//        for (Integer num : map.values()) {
//        res+=Math.abs(num);
//        }
//        return res/2;
//
//        }

//import java.io.*;
//import java.util.*;
//
///*
// * To execute Java, please define "static void main" on a class
// * named Solution.
// *
// * If you need more classes, simply define them inline.
// */
//
//class Solution {
//    public static void main(String[] args) {
//        ArrayList<String> strings = new ArrayList<String>();
//        strings.add("Hello, World!");
//        strings.add("Welcome to CoderPad.");
//        strings.add("This pad is running Java 8.");
//
//        for (String string : strings) {
//            System.out.println(string);
//        }
//
//        ////
//
//        String[] first = {"foog", "foo", "foo", "foo"};
//        String[] second ={ "food", "oof", "j", "abc"};
//        int [] result = getMinimumDifference(first, second);
//        for (int i : result) {
//            System.out.println(i);
//        }
//    }
//
//
//    // s1 = "foo","foo","foo","foo",
//    // s2 = "abc","foa","oof","foow",
//    // res = 3,     1,    0,    -1
//    // acdeeeee
//    // abcdeeee
//
//    // foo  f = 2, o = 2,
//    // oof
//
//
//    // foo f = 1 , ,o = 2
//    // oof o = 2, , f = 1
//
//
//    // fooge  +2 - 4 differences
//    // ofoge -2
//
//    /**
//     Time complexity for words as String[] O(N) (N - a number of words)
//     Time complexity for String as an input form array O(M) (M - a number if letters)
//     Memory complexity -  2*N (2 char arrays for 2 string arrays), 2*N - size of hashmap when we have all words different, in total: 2N + 2N = 4N (it means N)
//     **/
//    static int[] getMinimumDifference(String[] s1, String[] s2) {
//        int [] res = new int[s1.length];
//        for (int i = 0; i < s1.length; i++) {
//            if (s1[i].isEmpty() || s2[i].isEmpty()) {
//                res[i] = -1;
//            } else if (s1[i].length() != s2[i].length()) {
//                res[i] = -1;
//            } else {
//                char[] first = s1[i].toCharArray();
//                char[] second = s2[i].toCharArray();
//                Map<Character, Integer> checker = new HashMap<>();
//                for (int j = 0; j < first.length; j++) {
//                    if (first[j] != second[j]) {
//
//                        if (checker.containsKey(first[j])) {
//                            int charCounter = checker.get(first[j]);
//                            charCounter++;
//                            checker.put(first[j], charCounter);
//                        } else {
//                            checker.put(first[j], 1);
//                        }
//
//
//                        if (checker.containsKey(second[j])) {
//                            int charCounter = checker.get(second[j]);
//                            charCounter--;
//                            checker.put(second[j], charCounter);
//                        } else {
//                            checker.put(second[j], -1);
//                        }
//
//
//                    }
//                }
//                Set<Character> keys = checker.keySet();
//                int sum = 0;
//                for (Character character : keys) {
//                    int val = checker.get(character);
//                    sum += Math.abs(val);
//                }
//                res[i] = sum/2;
//            }
//        }
//        return res;
//    }
//}
//
//
//
///*
//Your previous Plain Text content is preserved below:
//


// */
//
