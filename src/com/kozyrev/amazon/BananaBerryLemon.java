package com.kozyrev.amazon;

import java.util.*;

/**
 * Created by skozyrev on 10/23/17.
 */
public class BananaBerryLemon {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java 8.");

        for (String string : strings) {
            System.out.println(string);
        }
        List<String> purch1 = new LinkedList<>();
        //apple, banana, lemon
        purch1.add("apple");
        purch1.add("banana");
        purch1.add("lemon");
        // banana, berry, lemon, orange
        List<String> purch2 = new LinkedList<>();
        purch2.add("banana");
        purch2.add("berry");
        purch2.add("lemon");
        purch2.add("orange");
        //banana, berry, lemon
        List<String> purch3 = new LinkedList<>();
        purch3.add("banana");
        purch3.add("berry");
        purch3.add("lemon");
        //Output:
        //Itemset Frequency
        //apple, banana 1
        //apple, lemon 1
        //banana, berry 2
        //banana, lemon 3
        //...
        //apple, banana, lemon 1
        //banana, berry, lemon 2
        //...
        //banana, berry, lemon, orange 1
        List<List<String>> quest = new ArrayList<>();
        quest.add(purch1);
        quest.add(purch2);
        quest.add(purch3);
        Map<Answer, Integer> map = findFrequesncies(quest);
        for (Answer a : map.keySet()) {
            System.out.println("");
            StringBuilder sb = new StringBuilder();
            for (String s : a.products) {
                sb.append(s).append(" ");
            }
            System.out.println(sb.toString() + " freq: " + map.get(a));
        }
    }


    public static Map<Answer, Integer> findFrequesncies(List<List<String>> purchases) {
        //algo impl,
        //1 find superlist
        //2 find superset pairs, three-s, etc.
        //3 calculate frequ for every set from step2
        List<List<List<String>>> superPuperList = new ArrayList<>();
        for (List<String> purchase : purchases) {
            List<List<String>> superList = getSuperList2(purchase);// magic
            List<List<String>> toRemove = new ArrayList<>();
            for (List<String> list : superList) {
                if (list.size() < 2) {
                    toRemove.add(list);
                }
            }
            superList.removeAll(toRemove);
            superPuperList.add(superList);
        }

        Map<Answer, Integer> map = new HashMap<>();
        for (List<List<String>> listOfLists : superPuperList) {
            for (List<String> list : listOfLists) {
                Answer a = Answer.fromList(list);
                if (map.containsKey(a)) {
                    map.put(a, map.get(a) + 1);
                } else {
                    map.put(a, 1);
                }
            }
        }

        return map;
    }

    public static List<List<String>> getSuperList2(List<String> list) {
        if (list.size() == 0) {
            return Collections.singletonList(list);
        } else {
            String item = list.get(0);
            List<List<String>> tempList = new ArrayList<>();
            for (List<String> subList : getSuperList2(list.subList(1, list.size()))) {
                List<String> withFirst = new ArrayList<>();
                withFirst.add(item);
                withFirst.addAll(subList);
                tempList.add(subList);
                tempList.add(withFirst);
            }
            return tempList;
        }
    }

    public static class Answer {

        public static Answer fromList(List<String> list) {
            Answer a = new Answer();
            for (String s : list) {
                a.products.add(s);
            }
            return a;
        }

        Set<String> products = new TreeSet<>();

        //class impl
        @Override
        public int hashCode() {
            if (products == null || products.size() == 0) {
                return super.hashCode();
            } else {
                int hashcode = 0;
                for (String s : products) {
                    hashcode += s.hashCode();
                }
                return hashcode;
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (products == null || products.size() == 0 || !(obj instanceof Answer)) {
                return super.equals(obj);
            } else {
                Answer second = (Answer) obj;
                if (products.size() != second.products.size()) {
                    return false;
                } else {
                    Iterator<String> i1 = products.iterator();
                    Iterator<String> i2 = second.products.iterator();
                    while (i1.hasNext()) {
                        if (!i1.next().equals(i2.next())) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
    }
}
