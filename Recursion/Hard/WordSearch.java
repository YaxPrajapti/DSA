package Recursion.Hard;

public class WordSearch {
    static boolean[][] visited; 
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'},{'A','D','E','E'}}; 
        String word = "ABCB"; 
        boolean isExist = exist(board, word); 
        System.out.println(isExist);
    }
    public static boolean exist(char[][] board, String word){
        int rows = board.length; 
        int columns = board[0].length;
        int index = 0; 
        visited = new boolean[rows][columns]; 
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean found = searchWord(i, j, word, board, index);
                    if(found) {
                        return true;
                    }
                }
            }
        }
        return false; 
    }
    private static boolean searchWord(int i, int j, String word, char[][] board, int index){
        if(index == word.length()){
            return true; 
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || visited[i][j] || word.charAt(index) != board[i][j]){
            return false; 
        }
        visited[i][j] = true; 
        if(searchWord(i-1, j, word, board, index+1) || searchWord(i+1, j, word, board, index+1) || searchWord(i, j+1, word, board, index+1) || searchWord(i, j-1, word, board, index+1)){
            return true; 
        }
        visited[i][j] = false; 
        return false; 
    }   
}
