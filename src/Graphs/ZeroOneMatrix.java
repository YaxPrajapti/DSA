package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    /**
     * Pair
     */
    static class Pair {
        int x; 
        int y;
        Pair(int x, int y){
            this.x = x; 
            this.y = y; 
        }
    }
    public static void main(String[] args) {
        
    }
    public static int[][] updateMatrix(int[][] mat) {
        int n = mat.length; 
        int m = mat[0].length; 
        int[][] res = new int[n][m]; 
        for(int[] row : res){
            Arrays.fill(row,-1);
        }
        Queue<Pair> q = new LinkedList<>(); 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j]== 0){
                    res[i][j] = 0; 
                    q.add(new Pair(i,j)); 
                }
            }
        }
        while(!q.isEmpty()){
            Pair p = q.poll(); 
            int x = p.x; 
            int y = p.y; 
            //go up; 
            if(x-1 >= 0 && res[x-1][y] == -1){
                res[x-1][y] = res[x][y]+1; 
                q.add(new Pair(x-1,y)); 
            }
            //go down; 
            if(x+1 < n && res[x+1][y] == -1){
                res[x+1][y] = res[x][y] + 1; 
                q.add(new Pair(x+1,y));
            }
            //go left; 
            if(y+1 < m && res[x][y+1] == -1){
                res[x][y+1] = res[x][y] + 1; 
                q.add(new Pair(x,y+1)); 
            }
            //go right; 
            if(y-1 >= 0 && res[x][y-1] == -1){
                res[x][y-1] = res[x][y] + 1; 
                q.add(new Pair(x,y-1)); 
            }
        }
        return res; 
    }
}
