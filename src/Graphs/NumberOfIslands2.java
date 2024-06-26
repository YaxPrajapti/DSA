package Graphs;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands2 {
    class DisjointSet {
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                size.add(1);
                parent.add(i);
            }
        }

        int findParent(int node) {
            if (parent.get(node) == node) {
                return node;
            }
            return findParent(parent.get(node));
        }

        public void union(int u, int v) {
            int ulp_u = findParent(u);
            int ulp_v = findParent(v);
            if (ulp_u == ulp_v) {
                return;
            }
            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));
            }
        }
    }

    private boolean isValid(int n, int m, int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        DisjointSet ds = new DisjointSet(rows * cols);
        List<Integer> ans = new ArrayList<>();
        int[][] visited = new int[rows][cols];
        int count = 0;
        for (int[] operator : operators) {
            int row = operator[0];
            int col = operator[1];
            if (visited[row][col] == 1) {
                ans.add(count);
                continue;
            }
            visited[row][col] = 1;
            count++;
            // check surrondings if it connects to the other islands.
            // row,col-1, row-1, col, row,col+1, row+1,col
            int[] drow = { 0, -1, 0, +1 };
            int[] dcol = { -1, 0, +1, 0 };
            for (int i = 0; i < 4; i++) {
                int new_row = row + drow[i];
                int new_col = col + dcol[i];
                if (isValid(rows, cols, new_row, new_col)) {
                    if (visited[new_row][new_col] == 1) {
                        int curr_node = row * cols + col;
                        int new_node = new_row * cols + new_col;
                        if (ds.findParent(curr_node) != ds.findParent(new_node)) {
                            count--;
                            ds.union(new_node, curr_node);
                        }
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
}
