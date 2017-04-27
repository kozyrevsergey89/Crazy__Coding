package com.kozyrev;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergii on 1/7/17.
 */
public class ProgressPie {

    public static final int NORMAL_CENTER = 50;
    private static final double R = 50d;

    static class InputSample {
        private int p;
        private double x;
        private double y;

        InputSample(int p, double x, double y) {
            this.p = p;
            this.x = x;
            this.y = y;
        }

        public int getP() {
            return p;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }

    List<Boolean> results = new ArrayList<>();

    void solve() {
        int order = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(new File("").getAbsolutePath().concat("/src/com/kozyrev/progress_pie.txt")))) {
            String line;
            while ((line = br.readLine()) != null) {
                // process the line.
                System.out.println(line);
                String[] lineArray = line.split(" ");
                if (lineArray.length == 3) {
                    solveForSample(new InputSample(Integer.parseInt(lineArray[0]), Double.parseDouble(lineArray[1]) -
                            NORMAL_CENTER, Double.parseDouble(lineArray[2]) - NORMAL_CENTER), order++);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter("out_res.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("resulting: ");
        for (int i = 0; i < results.size(); i++) {
            String outLine = "Case #" + (i + 1) + ": " + (results.get(i) ? "black" : "white");
            System.out.println(outLine);
            pw.write(outLine);
            pw.println();
        }

        pw.close();
    }

    private void solveForSample(InputSample sample, int order) {
        int correct = 0;
        if (sample.getX() >= 0 && sample.getY() < 0) {
            correct = 180;
        } else if (sample.getX() < 0 && sample.getY() < 0) {
            correct = 180;
        } else if (sample.getX() < 0 && sample.getY() >= 0) {
            correct = 360;
        } else {
            correct = 0;
        }

        double givenAngle = sample.getP() * 360d / 100d;
        double r = new BigDecimal(Math.sqrt(sample.getX() * sample.getX() + sample.getY() * sample.getY())).
                setScale(6, BigDecimal.ROUND_FLOOR).doubleValue();
        double teta = Math.toDegrees(Math.atan(sample.getX() / sample.getY()));
        boolean res = false;
        teta += correct;
        if (r <= R && teta >= 0 && teta <= givenAngle) {
            res = true;
        }
        results.add(res);
        System.out.println("x: " + sample.getX() + "  order=" + order + "  teta= " + teta + "  r=" + r);
    }
}
