package com.kozyrev;

import java.util.List;

import static java.util.Collections.max;
import static java.util.Collections.swap;

/**
 * Created by sergii on 9/15/16.
 */
public class AddBinaryStrings {

    public String addBinary(String a, String b) {

        int la = a.length();
        int lb = b.length();

        int max = Math.max(la, lb);

        StringBuilder sum = new StringBuilder("");
        int carry = 0;

        for (int i = 0; i < max; i++) {
            int m = getBit(a, la - i - 1);
            int n = getBit(b, lb - i - 1);
            int add = m + n + carry;
            sum.append(add % 2);
            carry = add / 2;
        }

        if (carry == 1)
            sum.append("1");

        return sum.reverse().toString();

    }

    public static int getBit(String s, int index) {
        if (index < 0 || index >= s.length())
            return 0;

        if (s.charAt(index) == '0')
            return 0;
        else
            return 1;
    }


    public static String addStrings(String s1, String s2) {
        StringBuilder sb = new StringBuilder("");
        int l1 = s1.length();
        int l2 = s2.length();
        int max = Math.max(l1, l2);
        int curry = 0;
        for (int i = 0; i < max; i++) {
            int b1 = getBit(s1, l1 - i - 1);
            int b2 = getBit(s2, l2 - i - 1);
            sb.append((b1 + b2 + curry) % 2);
            curry = (b1 + b2) / 2;
        }
        if (curry == 1) sb.append(1);
        return sb.reverse().toString();
    }

    public static List<Integer> removeValue(List<Integer> a, int v) {
        int i = 0;
        int t = a.size() - 1;
        while (i < t) {
            if (a.get(i) == v) {
                swap(a, i, t--);
            } else {
                i++;
            }
        }
        return a.subList(0, t);
    }
//сумма xbctk до определенного числа розрядов десятичных
    public static int digitFromPosition(int p) {
        int n = 0;
        int numberOfDigits = 1;
        int level = 0;
        int t = 0;
        while (numberOfDigits <= p) {
            n++;
            t = n;
            level = 0;
            while (t > 0) {
                t = t / 10;
                level++;
            }
            numberOfDigits += level;
        }
        int ans = 0;
        while (numberOfDigits != p) {
            ans = n % 10;
            n = n / 10;
            numberOfDigits--;

        }
        return ans;
    }
}
