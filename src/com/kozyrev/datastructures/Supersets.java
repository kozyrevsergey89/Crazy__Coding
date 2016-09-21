package com.kozyrev.datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sergii on 9/13/16.
 */
public class Supersets {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("1");
        names.add("2");
        names.add("3");
        names.add("4");
//        for (List<String> list : getSublists(names)) {
//            System.out.println();
//            for (String s : list) {
//                System.out.print(s + " ");
//            }
//        }

        System.out.println();
        System.out.print("my implementation:");
        System.out.println();

        for (List<String> list : getSuperList(names)) {
            System.out.println();
            for (String s : list) {
                System.out.print(s + " ");
            }
        }
    }

    static <T> List<List<T>> getSublists(List<T> list) {
        if (list.isEmpty()) {
            // if empty, return just that empty list
            return Collections.singletonList(list);
        } else {
            List<List<T>> sublists = new ArrayList<List<T>>();
            T first = list.get(0);
            // for each sublist starting at second element...
            for (List<T> sublist : getSublists(list.subList(1, list.size()))) {
                //... add that sublist with and without the first element
                // (two lines more, but this preserves the original order)
                List<T> sublistWithFirst = new ArrayList<T>();
                sublistWithFirst.add(first);
                sublistWithFirst.addAll(sublist);
                sublists.add(sublist);
                sublists.add(sublistWithFirst);
            }
            return sublists;
        }
    }


    public static <E> List<List<E>> getSuperList(List<E> list) {
        if (list.size() == 0) {
            return Collections.singletonList(list);
        } else {
            E item = list.get(0);
            List<List<E>> tempList = new ArrayList<>();
            for (List<E> subList : getSuperList(list.subList(1, list.size()))) {
                List<E> withFirst = new ArrayList<>();
                withFirst.add(item);
                withFirst.addAll(subList);
                tempList.add(subList);
                tempList.add(withFirst);
            }
            return tempList;
        }
    }


}
