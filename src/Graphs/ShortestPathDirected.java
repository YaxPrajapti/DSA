package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * -> we can solve this problem using the BFS. but there will be duplicacy so we will need to process the same node multiple times to find the shortest
 *    path to that node. 
 * -> To avoid this we will do some trick so that all prereq nodes are relaxed with as min as possible. 
 * -> Toposort will help us to do that.
 * -> we will first apply topo sort using dfs and will remove the element from the stack one by one. 
 * -> which will help us to determin the shortest path in single shot. which will eventually reduce the time complexity. 
 */

public class ShortestPathDirected {
    class Pair {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {

    }

    private static void toposort(int node, ArrayList<ArrayList<Pair>> adj, int[] visited, Stack<Integer> stack){
        visited[node] = 1; 
        for(Pair pair : adj.get(node)){
            int nei = pair.node; 
            int distance = pair.distance; 
            if(visited[nei] == 0){
                toposort(nei, adj, visited, stack);
            }
        }
        stack.add(node); 
    }
    public int[] shortestPathDFS(int N, int M, int[][] edges){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>(); 
        for(int i = 0; i < N; i++){
            adj.add(new ArrayList<>()); 
        }
        for(int i = 0; i < M; i++){
            int node = edges[i][0]; 
            int nei = edges[i][1]; 
            int wt = edges[i][2]; 
            adj.get(node).add(new Pair(nei, wt)); 
        }
        //will apply toposort here. 
        int[] visited = new int[N]; 
        Stack<Integer> stack = new Stack<>(); 
        for(int i = 0; i < N; i++){
            if(visited[i] == 0){
                toposort(i, adj, visited, stack); 
            }
        }

        //now relax the distances of the nodes while poping out the element from the node. 
        int[] dist = new int[N]; 
        dist[0] = 0; 
        while(!stack.isEmpty()){
            int node = stack.pop(); 
            int curr_dis = dist[node]; 
            for(Pair nei : adj.get(node)){
                int neighbour_node = nei.node; 
                int neighbour_distance = nei.distance; 
                dist[neighbour_node] = Math.min(dist[neighbour_node], curr_dis + neighbour_distance); 
            }
        }
        for(int i = 0; i < N; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1; 
            }
        }
        return dist; 
    }

    public int[] shortestPath(int N, int M, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int node = p.node;
            int distance = p.distance;
            dist[node] = Math.min(dist[node], distance);
            for (Pair pair : adj.get(node)) {
                if (dist[pair.node] > distance + pair.distance) {
                    q.add(new Pair(pair.node, pair.distance + distance));
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        return dist;
    }
}
