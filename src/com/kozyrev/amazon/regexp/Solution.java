package com.kozyrev.amazon.regexp;


class Solution {
    public static void main(String[] args) {
        System.out.println(isMatch("natasha", "nata5*sha"));
    }

    static boolean isMatch(String s, String p) {
        if (s==null || p == null) return false;


        return isMatch(s, p, 0, 0);
    }

    private static boolean isMatch(String s, String p, int si, int pi) {
        if (pi>= p.length() || si>=s.length()) {
            return false;
        }
        if (pi == p.length()-1 && si == s.length()-1) {
            return true;
        }
        if (pi < p.length()-1 && p.charAt(pi+1) == '*') {
            while((p.charAt(pi) == '.' || s.charAt(si) == p.charAt(pi)) && si<s.length()) {
                if (isMatch(s, p, si, pi+2)) return true;
                si++;
            }
        } else {
            if (p.charAt(pi) == '.' || s.charAt(si) == p.charAt(pi)) {
                return isMatch(s,p,si+1,pi+1);
            }
        }
        return isMatch(s, p, si, pi+2);
    }


}