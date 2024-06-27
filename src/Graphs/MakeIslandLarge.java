package Graphs;

import java.util.HashMap;

public class MakeIslandLarge {
    public static void main(String[] args) {
        int[][] grid = {{1,1},{1,0}};
        int ans = largestIsland(grid); 
        System.out.println(ans);
    }
    public static int largestIsland(int[][] grid) {
        int n = grid.length;
        int id = 2; 
        HashMap<Integer, Integer> map = new HashMap<>(); 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int count = 0; 
                    dfsAndPutId(n, grid, map, id, i, j, count);
                    id++; 
                }
            }
        }
        System.out.println(map);
        return 0; 
    }
    public static void dfsAndPutId(int n, int[][] grid, HashMap<Integer, Integer> map, int id, int i, int j, int count) {
        if(i < 0 || i >= n || j < 0 || j >= n){
            return; 
        }
        if(grid[i][j] > 1 || grid[i][j] == 0){
            return; 
        }
        grid[i][j] = id; 
        count++; 
        map.put(id, map.getOrDefault(id, 0)+1);
        dfsAndPutId(n, grid, map, id, i-1,j, count); 
        dfsAndPutId(n, grid, map, id, i,j+1, count); 
        dfsAndPutId(n, grid, map, id, i+1,j, count); 
        dfsAndPutId(n, grid, map, id, i,j-1, count); 
    }
}
