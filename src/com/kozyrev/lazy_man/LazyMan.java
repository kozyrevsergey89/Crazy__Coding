package com.kozyrev.lazy_man;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by sergii on 1/9/17.
 */
public class LazyMan {

    List<Integer> results = new ArrayList<>();

    public void solve() {
        int order = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(new File("").getAbsolutePath().concat("/src/com/kozyrev/lazy_man/lazy_loading.txt")))) {
            int days = Integer.parseInt(br.readLine());
            while (days != 0) {
                int itemsCount = Integer.parseInt(br.readLine());
                List<Integer> oneDayItems = new ArrayList<>();
                while (itemsCount != 0) {

                    oneDayItems.add(Integer.parseInt(br.readLine()));
                    itemsCount--;
                }
                Collections.sort(oneDayItems);
                solveForSample(oneDayItems, order);
                days--;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter("lazy_loading_res_out.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("resulting: ");
        for (int i = 0; i < results.size(); i++) {
            String outLine = "Case #" + (i + 1) + ": " + results.get(i);
            System.out.println(outLine);
            pw.write(outLine);
            pw.println();
        }

        pw.close();
    }

    private void solveForSample(List<Integer> items, int order) {
        int res = 0;
        while (items.size() != 0) {
            int last = items.remove(items.size() - 1);
            System.out.println(items.size());
            if (last >= 50) {
                res++;
            } else {
                if ((last + last * items.size()) < 50) {
                    if (res==0) res++;
                    break;
                } else {
                    int lastSum = last;
                    while (lastSum < 50 && !items.isEmpty()) {
                        lastSum += last;
                        items.remove(0);
                    }
                    res++;
                }
            }
        }
        //solve and assign res
        results.add(res);
    }
}