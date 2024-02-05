package POTD;

import java.util.Arrays;

public class MinimumFallingSumPath {
    public static void main(String[] args) {
        int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        int minFallingPathSum = minFallingPathSum(matrix);
        System.out.println(minFallingPathSum);
    }

    public static int minFallingPathSum(int[][] matrix) {
        int[] sum = { Integer.MAX_VALUE };
        int[][] dp = new int[matrix.length + 1][matrix.length + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < matrix.length; i++) {
            int temp = helper(sum, matrix, 0, i, 0, dp); 
            sum[0] = Math.min(sum[0],temp);
        }
        return sum[0]; 
    }

    private static int helper(int[] sum, int[][] matrix, int row, int col, int tempSum, int[][] dp) {
        if (row == matrix.length-1) {
            return matrix[row][col];
        }
        // tempSum += matrix[row][col];
        if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }
        int left = Integer.MAX_VALUE; 
        int right = Integer.MAX_VALUE; 
        if(col-1 >= 0){
            left = helper(sum, matrix, row + 1, col - 1, tempSum, dp);
        }
        int down = helper(sum, matrix, row + 1, col, tempSum, dp);
        if(col < matrix.length - 1){
            right = helper(sum, matrix, row + 1, col + 1, tempSum, dp);
        }
        dp[row][col] = Math.min(left, Math.min(down, right)) + matrix[row][col]; 
        return dp[row][col]; 
    }
}
