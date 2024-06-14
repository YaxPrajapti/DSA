package Graphs;

import java.util.ArrayList;

/**
 * CycleDetectionInDirectedGraph
 */

/*
 * -> it is the expansion of the cycle detection problem.
 * -> The traditional cycle detection algorithm will not work here because we
 * are having directed graphs.
 * -> We will keep track of the two things: if the node is visited or not and if
 * the node is visited in the path.
 * -> we will remove the path visited while backtracking but will keep it in the
 * visited array so that we can prevent the
 * frequent recursion calls.
 */
public class CycleDetectionInDirectedGraph {

    public static void main(String[] args) {

    }

    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        int[] pathVisited = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (dfs(V, adj, visited, pathVisited, i) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(int V, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathVisited, int src) {
        visited[src] = 1;
        pathVisited[src] = 1;
        for (Integer nei : adj.get(src)) {
            // if it is not visited then go for that node.
            if (visited[nei] == 0) {
                if (dfs(V, adj, visited, pathVisited, nei) == true) {
                    return true;
                }
            }
            // else if it is visited and neighbour node is visited and lies in the same path
            // then it is said that there is cycle in the path.
            else if (pathVisited[nei] == 1) {
                return true;
            }
        }
        pathVisited[src] = 0;
        return false;
    }
}