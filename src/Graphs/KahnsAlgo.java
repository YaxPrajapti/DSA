package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * This algorithm is same as topological sorting using BFS. 
 * -> Declare a Queue because it is BFS. and indegree array which stores the indegree of the node.
 * -> Add all nodes having indegree of 0 (no incoming edge) to the queue. 
 * -> take out nodes from the queue one by one and reduce the indegree for the adjacent nodes of that node. 
 * -> now if the adjecent node is having indegree of 0 then add it to the queue. 
 * 
 * -> intuition of adding nodes to the queue is: 
 *      we know that if the node is not having any incoming edge means that there is no one before that node. 
 *      lets take a scenario of scheduling a task. If a node does not have any incoming edge means that 
 *      that task do not have any prereq. so it can be performed now immediately. 
 */
public class KahnsAlgo {
    public static void main(String[] args) {
        
    }
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V]; 
        generateIndegree(V, adj, indegree); 
        Queue<Integer> q = new LinkedList<>(); 
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){ 
                q.add(i); 
            }
        }
        int[] order = new int[V]; 
        int index = 0; 
        while (!q.isEmpty()) {
            int node = q.poll(); 
            order[index++] = node; 
            for(Integer nei : adj.get(node)){
                indegree[nei]--; 
                if(indegree[nei] == 0){
                    q.add(nei); 
                }
            }
        }
        return order; 
    }
    public static void generateIndegree(int V, ArrayList<ArrayList<Integer>> adj, int[] indegree){
        for(int i = 0; i < V; i++){
            for(Integer node : adj.get(i)){
                indegree[node]++; 
            }
        }
    }
}
