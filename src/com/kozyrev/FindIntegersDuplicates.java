package com.kozyrev;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by skozyrev on 9/29/17.
 */
public class FindIntegersDuplicates {

    public static boolean hasDuplicates(int[] ar) {
        if (ar == null || ar.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (Integer i : ar) {
            if (!set.add(i)) return true;
        }
        return false;
    }

    public static boolean hasDuplicatesNoDataStructures(int[] ar) {
        if (ar == null || ar.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (Integer i : ar) {
            if (!set.add(i)) return true;
        }
        return false;
    }
}
