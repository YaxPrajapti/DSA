package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathDirected {
    class Pair{
        int node; 
        int distance; 
        Pair(int node, int distance){
            this.node = node; 
            this.distance = distance; 
        }
    }
    public static void main(String[] args) {

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
