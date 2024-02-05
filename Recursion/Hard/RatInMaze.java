package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
    public static void main(String[] args) {
        
        int[][] maze = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 } };
        
        // int[][] maze = { { 1, 1 },
        // { 1, 1 } };
        int n = maze.length; 
        List<String> path = findPath(maze, n);
        System.out.println(path);
    }

    private static ArrayList<String> findPath(int[][] maze, int n) {
        ArrayList<String> ans = new ArrayList<>();
        if (maze[n - 1][n - 1] == 0 || maze[0][0] == 0) {
            ans.add("-1");
        }
        int row = 0;
        int col = 0;
        StringBuilder st = new StringBuilder();
        int[][] visited = new int[n][n];
        solve(row, col, ans, n, st, visited, maze);
        return ans;
    }

    private static void solve(int row, int col, ArrayList<String> ans, int n, StringBuilder st, int[][] visited,
            int[][] maze) {
        if (row == n - 1 && col == n - 1) {
            ans.add(st.toString());
            return;
        }
        // lexicographical order = D L R U
        // make downwards turn
        if (maze[row][col] == 1) {
            visited[row][col] =1 ;
            if (row + 1 < n && visited[row + 1][col] == 0 && maze[row + 1][col] == 1) {
                visited[row + 1][col] = 1;
                st.append("D");
                solve(row + 1, col, ans, n, st, visited, maze);
                st.deleteCharAt(st.length() - 1);
                visited[row + 1][col] = 0;
            }
            // make left turn
            if (col - 1 >= 0 && visited[row][col - 1] == 0 && maze[row][col - 1] == 1) {
                visited[row][col - 1] = 1;
                st.append("L");
                solve(row, col - 1, ans, n, st, visited, maze);
                st.deleteCharAt(st.length() - 1);
                visited[row][col - 1] = 0;
            }
            // make right turn
            if (col + 1 < n && visited[row][col + 1] == 0 && maze[row][col + 1] == 1) {
                visited[row][col + 1] = 1;
                st.append("R");
                solve(row, col + 1, ans, n, st, visited, maze);
                st.deleteCharAt(st.length() - 1);
                visited[row][col + 1] = 0;
            }
            // make upward turn
            if (row - 1 >= 0 && visited[row - 1][col] == 0 && maze[row - 1][col] == 1) {
                visited[row - 1][col] = 1;
                st.append("U");
                solve(row - 1, col, ans, n, st, visited, maze);
                st.deleteCharAt(st.length() - 1);
                visited[row - 1][col] = 0;
            }
        }
    }
}
