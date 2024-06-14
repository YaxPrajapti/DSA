package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class PerfectSquares {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(numSquares(n));
    }
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return generate(n, dp);
    }
    private static int generate(int n, int[] dp){
        if(n == 0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int minCount = Integer.MAX_VALUE;
        for(int i = 1; i * i <= n; i++){
            int res = 1 + generate(n-(i*i), dp);
            minCount = Math.min(minCount, res);
        }
        dp[n]= minCount;
        return dp[n];
    }
}
