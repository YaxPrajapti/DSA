package Graphs;

import java.util.ArrayList;
import java.util.Stack;

/*
 * -> Only valid in DAG. 
 * -> Linear ordering of vertices such that if there is an edge between u and v then 
 *    u appears before v in the ordering. 
 * 
 *  Algorithm: 
 *      -> take stack and visited array. 
 *      -> Go for all the not visited nodes. call dfs and add them into stack after the recursion call. 
 *      -> After visiting all elements, pop out elements from the stack. that would be our final 
 *         topological order. 
 * 
 * Intuition: 
 *      -> we have to print the linear order in which it is called for the dfs. 
 *      -> That's why we are using the stack to keep track of which nodes have completed the 
 *         dfs call. 
 *      -> then we just pop out the elements. and it will give the proper ordering in 
 *         which the dfs call is made for the graph
 */
public class Topological {
    public static void main(String[] args) {

    }

    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(V, adj, stack, visited, i);
            }
        }
        int[] ans = new int[V];
        int index = 0;
        while (!stack.isEmpty()) {
            ans[index++] = stack.pop();
        }
        return ans;
    }

    private static void dfs(int V, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, int[] visited, int src) {
        visited[src] = 1;
        for (Integer nei : adj.get(src)) {
            if (visited[nei] == 0) {
                dfs(V, adj, stack, visited, nei);
            }
        }
        stack.push(src);
    }
}
