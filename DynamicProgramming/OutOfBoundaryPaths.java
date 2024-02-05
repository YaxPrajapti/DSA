package DynamicProgramming;

import java.util.Arrays;

public class OutOfBoundaryPaths {
    static final int mod = (int)Math.pow(10,9) + 7;
    public static void main(String[] args) {
        int temppaths = findPathstemp(2, 3, 8, 1, 0);
        int paths = findPaths(2, 3, 8, 1, 0);
        System.out.println("paths = " + paths);
        System.out.println("temppaths = " + temppaths);
    }

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove+1];
//        for(int i = 0; i < dp.length; i++){
//            for(int j = 0; j < dp[i].length; j++){
//                for(int k = 0; k < dp[i][j].length; k++){
//                    dp[i][j][k] = -1;
//                }
//            }
//        }
        return helper(m, n, maxMove, startRow, startColumn, dp);
    }

    private static int helper(int m, int n, int maxMove, int row, int col, int[][][] dp) {
        //path found
        if(row  < 0 || row >= m || col < 0 || col >= n){
            return 1;
        }
        if(maxMove == 0){
            return 0;
        }
        if(dp[row][col][maxMove] != 0){
            return dp[row][col][maxMove];
        }
        //move up
        int up = helper(m, n, maxMove - 1, row - 1, col, dp);
        //move left
        int left = helper(m, n, maxMove - 1, row, col - 1, dp);
        //move down
        int down = helper(m, n, maxMove - 1, row + 1, col, dp);
        //move right
        int right = helper(m, n, maxMove - 1, row, col + 1, dp);

        dp[row][col][maxMove] = (left + up + down + right) % mod;

        return dp[row][col][maxMove];
    }
    //optimized
    public static int findPathstemp(int m, int n, int N, int x, int y) {
        final int M = 1000000000 + 7;
        int[][] dp = new int[m][n];
        dp[x][y] = 1;
        int count = 0;

        for (int moves = 1; moves <= N; moves++) {
            int[][] temp = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == m - 1) count = (count + dp[i][j]) % M;
                    if (j == n - 1) count = (count + dp[i][j]) % M;
                    if (i == 0) count = (count + dp[i][j]) % M;
                    if (j == 0) count = (count + dp[i][j]) % M;
                    temp[i][j] = (
                            ((i > 0 ? dp[i - 1][j] : 0) + (i < m - 1 ? dp[i + 1][j] : 0)) % M +
                                    ((j > 0 ? dp[i][j - 1] : 0) + (j < n - 1 ? dp[i][j + 1] : 0)) % M
                    ) % M;
                }
            }
            dp = temp;
        }

        return count;
    }
}
