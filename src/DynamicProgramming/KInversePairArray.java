package DynamicProgramming;

import java.util.Arrays;

public class KInversePairArray {
    static final double mod = Math.pow(10, 9)+7;
    public static void main(String[] args) {
        int n = 3;
        int k = 1;
        int inversePairs = kInversePairsTabulation(n, k);
        System.out.println("inversePairs = " + inversePairs);
    }
    public static int kInversePairsTabulation(int n, int k){
        int[][] dp = new int[n+1][k+1];
        //dp[i][j] = total number of arrays having (1 to i) elements and k inversion;
        //for j = 0 (inversion = 0)
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k; j++){
                for(int inv = 0; inv <= Math.min(i-1, j); inv++){
                    dp[i][j] = (int) ((dp[i][j] % mod + dp[i-1][j-inv] % mod) % mod);
                }
            }
        }
        return dp[n][k];
    }
    public static int kInversePairsMemo(int n, int k){
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return solveMemo(n, k, dp);
    }

    private static int solveMemo(int n, int k, int[][] dp){
        if(n == 0){
            return 0;
        }
        if(k == 0){
            return 1;
        }
        if(dp[n][k] != -1){
            return dp[n][k];
        }
        double res = 0;
        for(int inv = 0; inv <= Math.min(n-1, k); inv++){
            res = (res % mod + solveMemo(n-1, k-inv, dp) % mod) % mod;
        }
        dp[n][k] = (int) res;
        return dp[n][k];
    }

}
