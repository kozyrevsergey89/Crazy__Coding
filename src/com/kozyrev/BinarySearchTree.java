package com.kozyrev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sergii on 10/18/16.
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private List<E> data;

    public BinarySearchTree() {
        data = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (Integer num : map.values()) {
            if (num!=0) {

            }
        }
    }

    public void insert(E item) {
        if (data.get(1) == null) {
            data.add(1, item); // adding top element
        } else {
            int k = 1;
            while (data.get(k) != null) {
                if (item.compareTo(data.get(k)) >= 0) {
                    k = 2 * k + 1;
                } else if (item.compareTo(data.get(k)) < 0) {
                    k = 2 * k;
                }
            }
            data.add(k, item);
        }
    }


}
