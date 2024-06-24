package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * This is greedy algorithm. 
 * we will use bfs and make optimal decision for which node to select as next node. 
 * we will select node having minimum weight which is next to the curr node. 
 * For that we will utilize priority queue, which will store the neighbour as a pair having min distance first. 
 * then we will pop that and go ahead by doing BFS. 
 */

public class DijkstraPosWeight {
    /**
     * Pair
     */
    static class Pair {

        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {

    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {
        PriorityQueue<Pair> q = new PriorityQueue<>((Pair a, Pair b) -> a.distance - b.distance); // min heap. to store the less weighted nodes first. 
        q.add(new Pair(src, 0));
        int[] visited = new int[V];
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int curr_node = p.node;
            int curr_dist = p.distance;
            visited[curr_node] = 1;
            dist[curr_node] = Math.min(dist[curr_node], curr_dist);
            for (ArrayList<Integer> neighbourList : adj.get(curr_node)) {
                if (visited[neighbourList.get(0)] == 0) {
                    q.add(new Pair(neighbourList.get(0), curr_dist + neighbourList.get(1)));
                }
            }
        }
        return dist;
    }
}
