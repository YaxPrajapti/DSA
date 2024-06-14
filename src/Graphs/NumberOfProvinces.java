package Graphs;
//the question is about finding the number connected components. 
//Make use of DFS traversal. 
public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}}; 
        int count = findCircleNum(isConnected); 
        System.out.println(count);
    }
    public static int findCircleNum(int[][] isConnected){
        int n = isConnected.length; 
        int[] visited = new int[n];
        int count = 0;
        for(int i = 0 ; i < n; i++){
            if(visited[i] == 0){
                count++; 
                dfs(isConnected, visited, i); 
            }
        }
        return count; 
    }
    public static void dfs(int[][] matrix, int[] visited, int index){
        visited[index] = 1; 
        for(int i = 0; i < matrix[index].length; i++){
            if(matrix[index][i] == 1 && visited[i] == 0){
                dfs(matrix, visited, i);
            }
        }
    }
}
