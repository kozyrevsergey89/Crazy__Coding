package com.kozyrev.amazon.find_the_shortest_path_between_two_cells;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        int[][] m = new int[][]{
                {0, -2, 0, 0, 0,   0,  0,  0,  0, 0},
                {0, 0, -1, 0, 0,  -3, -1, -1, -1, 0},
                {0, 0, 0,  0, -1, -6, 0, 0, 0, 0},
                {0, 0, 0, 0, -7, 0,  0, 0, 0, 0},
                {0, 0, 0, 0, -2, 0,  0, 0, 0, 0}
        };

        System.out.println(findShortestPath(m, 0,0,4,5));
    }

    static int findShortestPath(int[][] m, int xa, int ya, int xb, int yb) {
        int val = -1;
        m[xa][ya] = 1;
        Queue<Coord> q = new LinkedList<>();

        q.add(new Coord(xa, ya));
        while (!q.isEmpty()) {
            Coord coord = q.remove();
            val = m[coord.x][coord.y];
            if (coord.x == xb && coord.y == yb) {
                return val-1;
            }
            // bottom
            if (coord.x < m.length-1) {
                int x = coord.x + 1;
                int y = coord.y;
                if (m[x][y] == 0) {
                    m[x][y] = val+1;
                    q.add(new Coord(x, y));
                }
            }
            if (coord.x > 0) {
                int x = coord.x - 1;
                int y = coord.y;
                if (m[x][y] == 0) {
                    m[x][y] = val+1;
                    q.add(new Coord(x, y));
                }
            }

            if (coord.y < m[0].length-1) {
                int x = coord.x;
                int y = coord.y +1;
                if (m[x][y] == 0) {
                    m[x][y] = val+1;
                    q.add(new Coord(x, y));
                }
            }

            if (coord.y > 0) {
                int x = coord.x;
                int y = coord.y -1;
                if (m[x][y] == 0) {
                    m[x][y] = val+1;
                    q.add(new Coord(x, y));
                }
            }


        }
        return -1;
    }

    private static class Coord {
        int x;
        int y;

        private Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
