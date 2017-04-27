package com.kozyrev.pie_fanatics;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sergii on 1/15/17.
 */
public class PieFanatic {
    List<Integer> results = new ArrayList<>();

    public void solve() {
        int order = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(new File("").getAbsolutePath().concat("/src/com/kozyrev/pie_fanatics/pie_progress.txt")))) {
            int inputsTotal = Integer.parseInt(br.readLine());
            while (inputsTotal != 0) {
                String[] firstLine = br.readLine().split(" ");

                int daysCount = Integer.parseInt(firstLine[0]);
//                int itemsInOneDay = Integer.parseInt(firstLine[1]);
                List<Day> days = new ArrayList<>();
                while (daysCount != 0) {
                    List<Integer> oneDayList = new ArrayList<>();
                    String[] line = br.readLine().split(" ");
                    for (String s : line) {
                        oneDayList.add(Integer.parseInt(s));
                    }
                    daysCount--;
                    days.add(new Day(oneDayList));
                }
//                Collections.sort(oneDayItems);
                solveForSample(days, order);
                inputsTotal--;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter("pie_progress_output.txt"));
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

    private void solveForSample(List<Day> items, int order) {
        int res = 0;
        int daysToLive = items.size();
        int current = 0;

        while (daysToLive > 0) {
            res += pickCheapestOption(items, current++);
            daysToLive--;
        }

        for (Day d : items) {
            if (d.tax != 0) {
                res += Math.pow(d.tax, 2);
            }

        }
        //solve and assign res
        results.add(res);
    }

    private int pickCheapestOption(List<Day> items, int last) {
        int min = Integer.MAX_VALUE;
        int minDayIndex = -1;
        for (int i = 0; i <= last; i++) {
            if (!items.get(i).prices.isEmpty()) {
                int current = (int) (items.get(i).prices.get(0) + Math.pow(items.get(i).tax + 1, 2) - Math.pow(items.get(i).tax, 2));
                if (min > current) {
                    min = current;
                    minDayIndex = i;
                }
            }
        }
        int toRemove = items.get(minDayIndex).prices.remove(0);
        items.get(minDayIndex).tax += 1;
        return toRemove;
    }

    private static class Day {
        List<Integer> prices;
        int tax;

        public Day(List<Integer> list) {
            Collections.sort(list);
            prices = list;
            tax = 0;
        }
    }
}