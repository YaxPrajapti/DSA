package Graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class NumberOfDistinceIslands {
    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 0, 0, 0, 1, 1 },
                { 0, 0, 0, 1, 1 } };
        int count = countDistinctIslands(grid);
        System.out.println(count);
    }

    static int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 1) {
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i, j, grid, visited, i, j, list);
                    System.out.println("list: " + list);
                    set.add(list);
                }
            }
        }
        System.out.println(set);
        return set.size();
    }

    static void dfs(int base_row, int base_col, int[][] grid, int[][] visited, int row, int col,
            ArrayList<String> list) {
        visited[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;
        int row_diff = row - base_row;
        int col_diff = col - base_col;
        list.add(Integer.toString(row_diff) + " " + Integer.toString(col_diff));

        int[] nrow = { -1, 0, 1, 0 };
        int[] ncol = { 0, -1, 0, 1 };

        for (int i = 0; i < 4; i++) {
            int new_row = row + nrow[i];
            int new_col = col + ncol[i];

            if (new_row >= 0 && new_row < n && new_col >= 0 && new_col < m
                    && visited[new_row][new_col] == 0 && grid[new_row][new_col] == 1) {
                dfs(base_row, base_col, grid, visited, new_row, new_col, list);
            }
        }
    }
}
