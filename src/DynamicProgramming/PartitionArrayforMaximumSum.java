package DynamicProgramming;

import java.util.Arrays;

public class PartitionArrayforMaximumSum {
    public static void main(String[] args) {
        int[] arr = {1,15,7,9,2,5,10}; 
        int k = 3;
        int ans = maxSumAfterPartitioning(arr, k);
        System.out.println("ans = " + ans);
    }
    public static int maxSumAfterPartitioning(int[] arr, int k){
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return generate(arr, k, n, 0, dp);
    }
    private static int generate(int[] arr, int k, int n, int index, int[] dp){
        if(index == n){
            return 0;
        }
        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        if (dp[index] != -1){
            return dp[index];
        }
        for(int i = index; i < Math.min(index+k, n); i++){
            len++;
            maxi = Math.max(arr[i], maxi);
            int sum = maxi*len + generate(arr, k, n, i+1, dp);
            ans = Math.max(ans, sum);
        }
        dp[index] = ans;
        return dp[index];
    }
}
