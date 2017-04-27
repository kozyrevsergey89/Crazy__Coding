package com.kozyrev;


/**
 * Created by sergii on 10/24/16.
 */
public class Tasks {

    public static Pair method(int[] a, int s) {
        Pair p = null;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] >= s) {
                break;
            } else {
                int k = i + 1;
                while (a[i] + a[k] < s) {
                    k++;
                }
                if (a[i] + a[k] == s) {
                    p = new Pair();
                    p.first = a[i];
                    p.second = a[k];
                    return p;
                }
            }
        }
        return null;
    }

    public static Pair twoNumbersPairSum(int[] a, int s) {
        int h=0; int t=a.length-1;
        while(h<t){
            int pairSum = a[h]+a[t];
            if (pairSum==s) {
                return new Pair(a[h], a[t]);
            } else if (pairSum<s) {
                h++;
            } else {
                t--;
            }
        }
        return null;
    }




    static class Pair {
        int first;
        int second;

        public Pair() {
        }
        public Pair(int f, int s) {
            this.first=f;
            this.second=s;
        }
    }

}
