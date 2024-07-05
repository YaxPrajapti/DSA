package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * This algorithm is to find the bridges in the graph. 
 */

public class TarjansAlgo {
    public static void main(String[] args) {
        int[][] connections = { { 0, 1 }, { 1, 2 }, { 2, 0 }, { 1, 3 } };
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < connections.length; i++) {
            List<Integer> sublist = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                sublist.add(connections[i][j]);
            }
            list.add(sublist);
        }
        // System.out.println(list);
        int n = 4;
        TarjansAlgo ta = new TarjansAlgo();
        List<List<Integer>> bridges = ta.criticalConnections(n, list);
        System.out.println(bridges);
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> con : connections) {
            adj.get(con.get(0)).add(con.get(1));
            adj.get(con.get(1)).add(con.get(0));
        }
        int[] visited = new int[n];
        int[] insertion_time = new int[n];
        int[] lowest = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(n, adj, bridges, visited, insertion_time, lowest, 0, -1, 1);
        return bridges;
    }

    private void dfs(int n, List<List<Integer>> adj, List<List<Integer>> bridges, int[] visited, int[] insertion_time,
            int[] lowest, int node, int parent, int time) {
        visited[node] = 1;
        insertion_time[node] = time;
        lowest[node] = time;
        time++;
        for (Integer nei : adj.get(node)) {
            if (nei == parent) {
                continue;
            }
            if (visited[nei] == 0) {
                dfs(n, adj, bridges, visited, insertion_time, lowest, nei, node, time);
                lowest[node] = Math.min(lowest[node], lowest[nei]);
                if (lowest[nei] > lowest[node]) {
                    bridges.add(new ArrayList<>(Arrays.asList(nei, node)));
                }
            } else {
                lowest[node] = Math.min(lowest[node], lowest[nei]);
            }
        }
    }
}
