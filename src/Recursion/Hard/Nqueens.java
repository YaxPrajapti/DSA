package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class Nqueens {
    public static void main(String[] args) {
        int n = 4; 
        List<List<String>> board = solveNQueens(n); 
        System.out.println(board);
    }
    public static List<List<String>> solveNQueens(int n){
        char[][] board = new char[n][n]; 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.'; 
            }
        }
        List<List<String>> ans = new ArrayList<>(); 
        solve(0, board, ans, n); 
        return ans; 
    }
    private static void solve(int col, char[][] board, List<List<String>> ans, int n){
        if(col == n){
            ans.add(construct(board)); 
            return; 
        }
        for(int row = 0; row < n; row++){
            if(possible(row, col, board, ans, n)){
                board[row][col] = 'Q'; 
                solve(col+1, board, ans, n);
                board[row][col] = '.'; 
            }
        }
    }
    private static boolean possible(int row, int col, char[][] board, List<List<String>> ans, int n){
        int duprow = row; 
        int dupcol = col; 
        //diagonally upward
        while(row>=0 && col>=0){
            if(board[row][col]=='Q'){
                return false; 
            }
            row--; 
            col--; 
        }
        //horizontally backwards 
        row = duprow; 
        col = dupcol; 
        while(col>=0){
            if(board[row][col] == 'Q'){
                return false; 
            }
            col--;
        }
        row = duprow; 
        col = dupcol; 
        //diagonally downwards
        while(row < n && col>=0){
            if(board[row][col] == 'Q'){
                return false; 
            }
            row++; 
            col--;
        }
        return true; 
    }
    private static List<String> construct(char[][] board){
        List<String> res = new ArrayList<>(); 
        for(int i = 0; i<board.length; i++){
            String s = new String(board[i]);
            res.add(s);  
        }
        return res; 
    }
}
