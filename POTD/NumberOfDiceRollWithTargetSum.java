package POTD;

import java.util.Arrays;

public class NumberOfDiceRollWithTargetSum {
    public static void main(String[] args) {
        int n = 30; 
        int k = 30; 
        int target = 500; 
        int ways = numRollsToTarget(n, k, target); 
        System.out.println(ways); 
    }
    public static int numRollsToTarget(int n, int k, int target){
       int[][] dp = new int[n+1][target+1]; 
        for(int[] arr: dp){
            Arrays.fill(arr, -1); 
        }
        return solve(n, k, target, dp);
    }
    public static int solve(int dice, int faces, int target, int[][] dp){
        if(target < 0){
            return 0; 
        }
        if(dice == 0 && target != 0){
            return 0; 
        }
        if(dice != 0 && target == 0){
            return 0; 
        }
        if(dice == 0 && target == 0){
            return 1; 
        }
        if(dp[dice][target] != -1){
            return (int)(dp[dice][target]%(Math.pow(10,9)+7)); 
        }
        int ans = 0; 
        for(int i = 1; i <= faces; i++){
            ans = (ans + solve(dice - 1, faces, target - i, dp)) % (int) (Math.pow(10, 9) + 7); 
        }
        dp[dice][target] = ans; 
        return dp[dice][target]; 
    }
}
