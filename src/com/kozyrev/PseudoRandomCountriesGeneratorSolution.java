package com.kozyrev;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static com.kozyrev.PseudoRandomCountriesGeneratorSolution.Country.CANADA;
import static com.kozyrev.PseudoRandomCountriesGeneratorSolution.Country.UKRAINE;
import static com.kozyrev.PseudoRandomCountriesGeneratorSolution.Country.USA;


/**
 * Created by skozyrev on 10/3/17.
 */
public class PseudoRandomCountriesGeneratorSolution {

    Map<Country, Integer> map = new HashMap<>();

    public String generate() {
        if (map.isEmpty()) {
            System.out.println("resetting values");
            resetInitialValuesInMap();
        }
        Country country = countryFormKeySet(r.nextInt(map.keySet().size()));
        removeOrDecrease(country);
        return country.name();
    }

    private Country countryFormKeySet(int position) {
        int temp = 0;
        for (Country c : map.keySet()) {
            if (position == temp) return c;
            temp++;
        }
        return null;
    }

    private void removeOrDecrease(Country country) {
        Integer count = map.get(country);
        if (count == 1) {
            map.remove(country);
        } else {
            count--;
            map.put(country, count);
        }
    }

    private void resetInitialValuesInMap() {
        for (int i = 0; i < 10; i++) {
            if (i < 6) {
                addOrIncrease(USA);
            } else if (i < 8) {
                addOrIncrease(CANADA);
            } else {
                addOrIncrease(UKRAINE);
            }
        }
    }

    private void addOrIncrease(Country country) {
        Integer count = map.get(country);
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        map.put(country, count);
    }

    private static Random r = new Random();


    public static void main(String[] args) {
        PseudoRandomCountriesGeneratorSolution solution = new PseudoRandomCountriesGeneratorSolution();
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
        System.out.println(solution.generate());
    }


    enum Country {
        USA, CANADA, UKRAINE;
    }
}
