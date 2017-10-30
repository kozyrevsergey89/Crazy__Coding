package com.kozyrev.amazon.longest_palindrome;

/**
 * Created by skozyrev on 10/30/17.
 */
class Solution {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
//        System.out.println(longestPalindrome("abab"));
//        System.out.println(longestPalindrome("abab"));
//        System.out.println(longestPalindrome("abab"));
//        System.out.println(longestPalindrome("abab"));
//        System.out.println(longestPalindrome("abab"));
//        System.out.println(longestPalindrome("abab"));
//        System.out.println(longestPalindrome("abab"));
//        System.out.println(longestPalindrome("abab"));
//        System.out.println(longestPalindrome("abab"));
    }

    public static String longestPalindrome(String s) {
        int lo = 0;
        String longest = "";
        int hi = 0;

        while (lo < s.length() - 1) {
            hi = lo;
            while (hi < s.length()) {
                if (hi < lo) {
                    hi = lo;
                }
                String cur = s.substring(lo, hi);
                if (isPalindrome(cur)) {
                    if (cur.length() > longest.length()) {
                        longest = cur;

                    }

                }
                hi++;
            }
            lo++;
        }

        return longest;
    }

    static boolean isPalindrome(String s) {
        int lo = 0;
        int hi = s.length() - 1;
        while (lo < hi) {
            if (s.charAt(lo) == s.charAt(hi)) {
                lo++;
                hi--;

            } else {
                return false;
            }
        }
        return true;
    }
}
