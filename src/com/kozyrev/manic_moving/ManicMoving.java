package com.kozyrev.manic_moving;

import com.kozyrev.pie_fanatics.PieFanatic;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sergii on 1/15/17.
 */
public class ManicMoving {
    List<Integer> results = new ArrayList<>();

    public void solve() {
        int order = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(new File("").getAbsolutePath().concat("/src/com/kozyrev/manic_moving/manic_moving_example_input.txt")))) {
            int inputsTotal = Integer.parseInt(br.readLine());
            while (inputsTotal != 0) {
                String[] firstLine = br.readLine().split(" ");
                int numberOfCities=Integer.parseInt(firstLine[0]);
                int numberOfRoads=Integer.parseInt(firstLine[1]);
                int numberOfFamilies=Integer.parseInt(firstLine[2]);
                List<Road> roads = new ArrayList<>();
                while (numberOfRoads != 0) {
                    String[] line = br.readLine().split(" ");
                    roads.add(new Road(Integer.parseInt(line[0]),Integer.parseInt(line[1]),Integer.parseInt(line[2])));
                    numberOfRoads--;
                }
                List<FamilyRoute> familyRoutes = new ArrayList<>();
                while (numberOfFamilies != 0) {
                    String[] line = br.readLine().split(" ");
                    familyRoutes.add(new FamilyRoute(Integer.parseInt(line[0]),Integer.parseInt(line[1])));
                    numberOfFamilies--;
                }

                solveForSample(roads, familyRoutes, order);
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

    private void solveForSample(List<Road> roads, List<FamilyRoute> familyRoutes, int order) {
        int res = 0;
        int start = 1;

        //solve and assign res
        results.add(res);
    }




    private static class FamilyRoute {
        public FamilyRoute(int from, int to) {
            start = from;
            destination = to;
        }

        int start;
        int destination;
        int totalGasPrice;
    }

    private static class Road {
        public Road(int from, int to, int gas) {
            start = from;
            destination = to;
            this.gas = gas;
        }

        int start;
        int destination;
        int gas;
    }
}
