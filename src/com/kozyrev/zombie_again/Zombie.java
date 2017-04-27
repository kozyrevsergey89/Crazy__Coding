package com.kozyrev.zombie_again;


import java.io.*;
import java.util.*;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


/**
 * Created by sergii on 1/15/17.
 */
public class Zombie {

    List<Integer> results = new ArrayList<>();

    public void solve() {
        int order = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(new File("").getAbsolutePath().concat("/src/com/kozyrev/zombie_again/fighting_the_zombies.txt")))) {
            int inputsTotal = Integer.parseInt(br.readLine());
            while (inputsTotal != 0) {
                String[] firstLine = br.readLine().split(" ");

                int zombiesCount = Integer.parseInt(firstLine[0]);
                double radius = Double.parseDouble(firstLine[1]);
                List<Coord> zombies = new ArrayList<>();
                while (zombiesCount != 0) {
                    String[] line = br.readLine().split(" ");
                    zombies.add(new Coord(Double.parseDouble(line[0]), Double.parseDouble(line[1])));
                    zombiesCount--;
                }
                solveForSampleSq(new Hoordaa(zombies, radius), order);
                inputsTotal--;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter("fighting_the_zombies_output.txt"));
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

    private void solveForSample(Hoordaa hoordaa, int order) {
        int res = 0;
        Set<Coord> max = new HashSet<>();
        for (int i = 0; i < hoordaa.zombies.size() - 1; i++) {
            for (int j = i + 1; j < hoordaa.zombies.size(); j++) {
                Set<Coord> zombiesInTwoPointSet = getZombiesInTwoPointsCircle(hoordaa, hoordaa.zombies.get(i), hoordaa.zombies.get(j), hoordaa.r);
                if (zombiesInTwoPointSet != null && max.size() < zombiesInTwoPointSet.size()) {
                    max = zombiesInTwoPointSet;
                }
            }
        }

        for (Coord c : max) {
            hoordaa.zombies.remove(c);
        }

        Set<Coord> secondSet = new HashSet<>();
        for (int i = 0; i < hoordaa.zombies.size() - 1; i++) {
            for (int j = i + 1; j < hoordaa.zombies.size(); j++) {
                Set<Coord> zombiesInTwoPointSet = getZombiesInTwoPointsCircle(hoordaa, hoordaa.zombies.get(i), hoordaa.zombies.get(j), hoordaa.r);
                if (zombiesInTwoPointSet != null && secondSet.size() < zombiesInTwoPointSet.size()) {
                    secondSet = zombiesInTwoPointSet;
                }
            }
        }
        res += max.size() + secondSet.size();
        //solve and assign res
        results.add(res);
    }

    private void solveForSampleSq(Hoordaa hoordaa, int order) {
        int res = 0;
        Set<Coord> max = new HashSet<>();
        for (int i = 0; i < hoordaa.zombies.size() - 1; i++) {
            Set<Coord> zombiesInTwoPointSet = getZombiesInTwoPointsSq(hoordaa, hoordaa.zombies.get(i), hoordaa.r);
            if (zombiesInTwoPointSet != null && max.size() < zombiesInTwoPointSet.size()) {
                max = zombiesInTwoPointSet;
            }
        }

        for (Coord c : max) {
            hoordaa.zombies.remove(c);
        }

        Set<Coord> secondSet = new HashSet<>();
        for (int i = 0; i < hoordaa.zombies.size() - 1; i++) {
            Set<Coord> zombiesInTwoPointSet = getZombiesInTwoPointsSq(hoordaa, hoordaa.zombies.get(i), hoordaa.r);
            if (zombiesInTwoPointSet != null && secondSet.size() < zombiesInTwoPointSet.size()) {
                secondSet = zombiesInTwoPointSet;
            }
        }
        res += max.size() + secondSet.size();
        //solve and assign res
        results.add(res);
    }

    private Set<Coord> getZombiesInTwoPointsSq(Hoordaa hoordaa, Coord coord1, double r) {
        double x = coord1.x;
        double y = coord1.y;

        HashSet<Coord> zFirst = zombiesInSq(hoordaa.zombies, coord1, x, y, x + r, y, x + r, y - r, x, y - r);
        HashSet<Coord> zSecond = zombiesInSq(hoordaa.zombies, coord1, x - r, y, x, y, x, y - r, x - r, y - r);
        HashSet<Coord> zThird = zombiesInSq(hoordaa.zombies, coord1, x - r, y + r, x, y + r, x, y, x - r, y);
        HashSet<Coord> zFourth = zombiesInSq(hoordaa.zombies, coord1, x, y + r, x + r, y + r, x + r, y, x, y);
        if (zFirst.size() >= zSecond.size() && zFirst.size() >= zThird.size() && zFirst.size() >= zFourth.size()) {
            return zFirst;
        } else if (zSecond.size() >= zFirst.size() && zSecond.size() >= zThird.size() && zSecond.size() >= zFourth.size()) {
            return zSecond;
        } else if (zThird.size() >= zSecond.size() && zThird.size() >= zFirst.size() && zThird.size() >= zFourth.size()) {
            return zThird;
        } else if (zFourth.size() >= zSecond.size() && zFourth.size() >= zThird.size() && zFourth.size() >= zFirst.size()) {
            return zFourth;
        } else {
            return null;
        }
    }

    private HashSet<Coord> zombiesInSq(List<Coord> zombies, Coord coord1, double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        HashSet<Coord> killable = new HashSet<>();
        for (Coord c : zombies) {
            if (!c.equals(coord1)) {
                //is in the circle
                if (c.x >= x1 && c.y <= y1 && c.x <= x2 && c.y <= y2 && c.x <= x3 && c.y >= y3 && c.x >= x4 && c.y >= y4) {
                    killable.add(c);
                }
            }
        }
        killable.add(coord1);
        return killable;
    }

    private HashSet<Coord> getZombiesInTwoPointsCircle(Hoordaa hoordaa, Coord coord1, Coord coord2, double r) {
        double x1 = coord1.x;
        double y1 = coord1.y;
        double x2 = coord2.x;
        double y2 = coord2.y;

        double q = sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
        if (q > 2 * r) {
            return null;
        }
        double x3 = (x1 + x2) / 2;
        double y3 = (y1 + y2) / 2;

        double cx1 = x3 + sqrt(pow(r, 2) - pow(q / 2, 2)) * (y1 - y2) / q;
        double cy1 = y3 + sqrt(pow(r, 2) - pow(q / 2, 2)) * (x2 - x1) / q;

        double cx2 = x3 - sqrt(pow(r, 2) - pow(q / 2, 2)) * (y1 - y2) / q;
        double cy2 = y3 - sqrt(pow(r, 2) - pow(q / 2, 2)) * (x2 - x1) / q;

        HashSet<Coord> zombiesInFirstCircle = zombiesInCircle(hoordaa.zombies, coord1, coord2, cx1, cy1, r);
        HashSet<Coord> zombiesInSecondCircle = zombiesInCircle(hoordaa.zombies, coord1, coord2, cx2, cy2, r);


        return zombiesInFirstCircle.size() > zombiesInSecondCircle.size() ? zombiesInFirstCircle : zombiesInSecondCircle;
    }

    private HashSet<Coord> zombiesInCircle(List<Coord> zombies, Coord coord1, Coord coord2, double cx1, double cy1, double r) {
        HashSet<Coord> killable = new HashSet<>();
        for (Coord c : zombies) {
            if (!c.equals(coord1) && !c.equals(coord2)) {
                //is in the circle
                if (pow(c.x - cx1, 2) + pow(c.y - cy1, 2) <= pow(r, 2)) {
                    killable.add(c);
                }
            }
        }
        killable.add(coord1);
        killable.add(coord2);
        return killable;
    }


    private static class Coord {
        public Coord(double x, double y) {
            this.x = x;
            this.y = y;
        }

        double x;
        double y;
    }

    private static class Hoordaa {
        List<Coord> zombies;
        double r;

        public Hoordaa(List<Coord> list, double r) {
            zombies = list;
            this.r = r;
        }
    }
}