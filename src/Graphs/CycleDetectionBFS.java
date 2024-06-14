package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionBFS {
    /**
     * Pair
     */
    static class Pair {
        int curr; 
        int parent;
        Pair(int curr, int parent){
            this.curr = curr; 
            this.parent = parent; 
        }
    }
    public static void main(String[] args) {
        /*
        Intuition: 
            we will be doing BFS traversal. 
            In bfs only parent node is visited. 
            So we will check if the node next to curr is visited and is not parent node. That means, It is already visited by other 
            node. and there is cycle because we are starting from two different nodes and meeting to the same node. 
         */    
        int V = 4; 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); 
        int[][] arr = {{}, {2}, {1, 3}, {2}}; 
        for(int i = 0; i < arr.length; i++){
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
                if(bfs(i, V, adj, visited)) return true;
            }
        }
        return false; 
    }
    public static boolean bfs(int src, int V, ArrayList<ArrayList<Integer>> adj, int[] visited){
        Queue<Pair> q = new LinkedList<>(); 
        visited[src] = 1; 
        q.add(new Pair(src, -1)); 
        while (!q.isEmpty()) {
            Pair p = q.poll(); 
            int curr = p.curr; 
            int parent = p.parent; 
            for(Integer adjNode: adj.get(curr)){
                //if it is not visited then add to queue. 
                if(visited[adjNode] == 0){
                    q.add(new Pair(adjNode, curr)); 
                    visited[adjNode] = 1; 
                }else{
                    //if it is visited, then it must be parent of curr node else there is a cycle
                    if(adjNode != parent){
                        return true; 
                    }
                }
            }
        }
        return false; 
    }

}
