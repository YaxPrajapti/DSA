package POTD;

public class AntiDiagonalTraversal {
    public static void main(String[] args) {
        // int[][] matrix = { { 3, 2, 3 }, { 4, 5, 1 }, { 7, 8, 9 } };
        int[][] matrix = {{1,2},{3,4}}; 
        int[] ans = antiDiagonalPattern(matrix); 
        for(int i : ans){
            System.out.print(i + " ");
        }
    }

    public static int[] antiDiagonalPattern(int[][] matrix) {
        int N = matrix.length;
        int[] ans = new int[N * N];
        int row = 0;
        int col = 0;
        int i = 0;
        while (row < N && col < N) {
            ans[i] = matrix[row][col];
            i++;
            if (col - 1 < 0) {
                int tempCol = col; 
                col = row + 1; 
                if(col >= N){
                    // int tempRow = tempCol+1; 
                    col = row;
                    row = tempCol + 1; 
                }else{
                    row = 0; 
                }
            }
            else {
                if(row + 1 >= N){
                    int tempRow = col+1; 
                    col = row; 
                    row = tempRow; 
                }else{
                    row++;
                    col--;
                }
            }
        }
        return ans;
    }
}
