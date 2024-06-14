package Graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CycleDetectionDFS {
    public static void main(String[] args) {
        int[][] arr = {{}, {2}, {1, 3}, {2}}; 
        int V = 4; 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); 
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>()); 
            for(int j = 0; j < arr[i].length; j++){
                adj.get(i).add(arr[i][j]); 
            }
        }
        boolean ans = isCycle(V, adj); 
        System.out.println(ans);
    }
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        int[] visited = new int[V]; 
        for(int i = 0; i < V; i++){
            if(visited[i] == 0){
                if(dfs(adj, visited, i, -1) == true){
                    return true; 
                }
            }
        }
        return false; 
    }
    private static boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] visited, int src, int parent){
        visited[src] = 1; 
        for(Integer adjNode : adj.get(src)){
            if(visited[adjNode] == 0){
                if(dfs(adj, visited, adjNode, src) == true){
                    return true; 
                }
            }
            else {
                if(adjNode != parent){
                    return true; 
                }
            }
        }
        return false; 
    }

}
