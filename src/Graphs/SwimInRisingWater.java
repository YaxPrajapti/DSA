package Graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SwimInRisingWater {
    static class Pair {
        int row;
        int col;
        int t;

        Pair(int x, int y, int t) {
            this.row = x;
            this.col = y;
            this.t = t;
        }

    }

    public static void main(String[] args) {
        // int[][] grid = {{0,2},{1,3}}; 
        int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        int ans = swimInWater(grid);
        System.out.println(ans);
    }

    public static int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n]; // this will store the min dist.
        for (int[] row : dist) {
            Arrays.fill(row, (int) 1e9);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> a.t - b.t);
        int t = grid[0][0];
        pq.add(new Pair(0, 0, t));
        dist[0][0] = t;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int x = p.row;
            int y = p.col;
            int time = p.t;
            t = Math.max(time, t);
            if (x == n - 1 && y == n - 1) {
                return t;
            }
            // (row,col-1) (row-1 col) (row col+1) (row+1 col)
            int[] drow = { 0, -1, 0, +1 };
            int[] dcol = { -1, 0, +1, 0 };
            for (int i = 0; i < 4; i++) {
                int new_row = x + drow[i];
                int new_col = y + dcol[i];
                if (new_row >= 0 && new_row < n && new_col >= 0 && new_col < n) {
                    int new_time = grid[new_row][new_col];
                    if (new_time < dist[new_row][new_col]) {
                        pq.add(new Pair(new_row, new_col, new_time));
                        dist[new_row][new_col] = new_time;
                    }
                }
            }
        }
        return dist[n - 1][n - 1];
    }
}
