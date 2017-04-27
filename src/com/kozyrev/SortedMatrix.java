package com.kozyrev;

/**
 * Created by sergii on 10/18/16.
 */
public class SortedMatrix {

    // assume columns and rows are sorted in matrix, example:
    // 1,2,3
    // 1,3,5
    // 3,5,10
    public static boolean contains(int[][] m, int v) {
        int x = m[0].length - 1;
        int y = 0;
        while (y < m.length && x >= 0) {
            if (v < m[y][x]) {
                x--;
            } else if (v > m[y][x]) {
                y++;
            } else {
                return true;
            }
        }
        return false;
    }
}
