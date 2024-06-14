package Graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * This question is about finding number of connected components in graph. 
 */

class NumberOfIslands {
    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        char[][] grid = { { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } };
        int count = numIslands(grid); 
        System.out.println(count);
    }

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    if (!visited[i][j]) {
                        count++;
                        bfs(grid, n, m, i, j, visited);
                    }
                }
            }
        }
        return count;
    }

    public static void bfs(char[][] grid, int n, int m, int row, int col, boolean[][] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        visited[row][col] = true;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            // go up
            if (x - 1 >= 0 && visited[x - 1][y] == false && grid[x - 1][y] == '1') {
                q.add(new Pair(x - 1, y));
                visited[x - 1][y] = true;
            }
            // go down
            if (x + 1 < n && visited[x + 1][y] == false && grid[x + 1][y] == '1') {
                q.add(new Pair(x + 1, y));
                visited[x + 1][y] = true;
            }
            // go left
            if (y - 1 >= 0 && visited[x][y - 1] == false && grid[x][y - 1] == '1') {
                q.add(new Pair(x, y - 1));
                visited[x][y - 1] = true;
            }
            // go right
            if (y + 1 < m && visited[x][y + 1] == false && grid[x][y + 1] == '1') {
                q.add(new Pair(x, y + 1));
                visited[x][y + 1] = true;
            }
        }
    }
}