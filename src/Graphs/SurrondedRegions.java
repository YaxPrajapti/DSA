package Graphs;

public class SurrondedRegions {
    public static void main(String[] args) {
       char[][] board = {{'O','O'},{'O','O'}}; 
       int n = board.length; 
       int m = board[0].length; 
       solve(board);
       for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
       }
    }
    public void solve(char[][] board) {
        int n = board.length; 
        int m = board[0].length;
        int[][] visited = new int[n][m];
        //traverse borders. 
        //go top left to top right; 
        for(int i = 0; i < m; i++){
            if(visited[0][i] == 0 && board[0][i] == 'O'){
                dfs(0,i,board,visited); 
            }
        }
        //go top right to bottom right; 
        for(int i = 0; i < n; i++){
            if(visited[i][m-1] == 0 && board[i][m-1] == 'O'){
                dfs(i,m-1,board,visited); 
            }
        }
        //go bottom left to bottom right; 
        for(int i = 0; i < m; i++){
            if(visited[n-1][i] == 0 && board[n-1][i] == 'O'){
                dfs(n-1,i,board,visited); 
            }
        }
        //go top left to bottom left; 
        for(int i = 0; i < n; i++){
            if(visited[i][0] == 0 && board[i][0] == 'O'){
                dfs(i, 0, board, visited); 
            }
        }
        //replace the 0s with Xs
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O' && visited[i][j] == 0){
                    board[i][j] = 'X'; 
                }
            }
        }
    }
    private void dfs(int row, int col, char[][] board, int[][] visited){
        int n = board.length; 
        int m = board[0].length;
        visited[row][col] = 1; 
        //go up 
        if(row-1>=0 && board[row-1][col]=='O' && visited[row-1][col]==0){
            dfs(row-1,col,board,visited); 
        }
        //go down
        if(row+1 < n && board[row+1][col]=='O' && visited[row+1][col]==0){
            dfs(row+1,col,board,visited); 
        }
        //go right
        if(col+1 < m && board[row][col+1]=='O' && visited[row][col+1]==0){
            dfs(row,col+1,board,visited); 
        }
        //go left
        if(col-1>=0 && board[row][col-1]=='O' && visited[row][col-1]==0){
            dfs(row,col-1,board,visited); 
        }
}
