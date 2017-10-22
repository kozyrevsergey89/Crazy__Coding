package com.kozyrev.amazon.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> checkMap = new HashMap<>();
        char[] chars = s.toCharArray();
        int res = 0;
        int maxRes = 0;
        for (int i = 0; i < chars.length; ) {
            char c = chars[i];
            if (checkMap.containsKey(c)) {
                // repeat found...
                if (res > maxRes) {
                    maxRes = res;
                }
                res = 0;
                i = checkMap.get(c) + 1;
                checkMap.clear();
            } else {
                checkMap.put(c, i);
                res++;
                i++;
            }
        }
        if (res > maxRes) {
            maxRes = res;
        }
        return maxRes;
    }
}
