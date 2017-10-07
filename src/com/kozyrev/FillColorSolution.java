package com.kozyrev;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by skozyrev on 10/3/17.
 */
public class FillColorSolution {

    public void fillColor(int[][] img, int x, int y, int givenColor) {
        if (img == null || img.length == 0 || img[0].length == 0 || x >= img.length || y >= img[0].length) {
            return;
        }
        Queue<Coord> q = new LinkedList<>();
        q.add(new Coord(x, y));
        int oldColor = img[x][y];
        while (!q.isEmpty()) {
            Coord coord = q.remove();
            //add 4 ways
            if (coord.x - 1 > 0 && img[coord.x - 1][coord.y] == oldColor) q.add(new Coord(coord.x - 1, coord.y));
            if (coord.x + 1 < img.length && img[coord.x + 1][coord.y] == oldColor)
                q.add(new Coord(coord.x + 1, coord.y));
            if (coord.y - 1 > 0 && img[coord.x][coord.y - 1] == oldColor) q.add(new Coord(coord.x, coord.y - 1));
            if (coord.y + 1 < img[0].length && img[coord.x][coord.y + 1] == oldColor)
                q.add(new Coord(coord.x, coord.y + 1));
            img[coord.x][coord.y] = givenColor;
        }

    }

    static class Coord {
        int x;
        int y;

        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
