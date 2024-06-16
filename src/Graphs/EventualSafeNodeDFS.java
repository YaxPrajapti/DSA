package Graphs;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeNodeDFS {
    public static void main(String[] args) {
        
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length; 
        int[] visited = new int[n]; 
        int[] pathvisited = new int[n]; 
        int[] checked = new int[n]; 
        List<Integer> list = new ArrayList<>(); 
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                dfs(visited, pathvisited, graph, i, checked); 
            }
        }
        for(int i = 0; i < n; i++){
            if(checked[i] == 1){
                list.add(i); 
            }
        }
        return list; 
    }
    private boolean dfs(int[] visited, int[] pathvisited, int[][] graph, int src, int[] checked){
        visited[src] = 1; 
        pathvisited[src] = 1; 
        checked[src] = 0; 
        for(Integer nei : graph[src]){
            // if the nei is not visited then go for it. 
            if(visited[nei] == 0){
                if(dfs(visited, pathvisited, graph, nei, checked) == true) {
                    checked[src] = 0; 
                    return true; 
                }
            }else if (pathvisited[nei] == 1){
                checked[src] = 0; 
                return true; 
            }
        }
        checked[src] = 1; 
        pathvisited[src] = 0; 
        return false; 
    }
}
