package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 4; 
        List<List<String>> queens = solveNQueens(n); 
        System.out.println(queens);
    }
    public static List<List<String>> solveNQueens(int n){
        List<List<String>> board = new ArrayList<>(); 
        List<String> column = new ArrayList<>(); 
        for(int i = 0; i < n; i++){
            board.add(i, new ArrayList<>()); 
            for(int j = 0; j < n; j++){
                board.get(i).add("."); 
            }
        }
        return board; 
    }
}
