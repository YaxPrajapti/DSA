package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUndirected {
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

    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        // System.out.println(adj);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int node = p.node;
            int distance = p.distance;
            dist[node] = Math.min(distance, dist[node]);
            for (Integer nei : adj.get(node)) {
                if (dist[nei] > distance + 1) {
                    q.add(new Pair(nei, distance + 1));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        return dist;
    }
}
