package DynamicProgramming;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = {1,2,1,2};
        int money = rob(arr);
        System.out.println("money = " + money);
    }
    public static int rob(int[] nums){
        int[] sum = {0};
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(nums, sum, 0, n, 0, dp);

    }
    private static int helper(int[] nums, int[] sum, int index, int n, int tempSum, int[] dp)
    {
//        if (index >= n) {
//            return tempSum;
//        }
//        if (dp[index] != -1) {
//            return dp[index];
//        }
//        tempSum += nums[index];
//        // we chose to pick this
//        int chose = helper(nums, sum, index + 2, n, tempSum, dp);
//        tempSum -= nums[index];
//        // we chose to not pick this
//        int notChose = helper(nums, sum, index + 1, n, tempSum, dp);
//        // we will update the dp array having the maximum amount of money a robber can have if he chose to rob this house.
//        dp[index] = Math.max(chose, notChose);
//        sum[0] = Math.max(dp[index], sum[0]);
//        return dp[index];

        if(index >= n){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int chose = nums[index] + helper(nums, sum, index+2, n, tempSum, dp);
        int notChose = helper(nums, sum, index+1, n, tempSum, dp);
        dp[index] = Math.max(chose, notChose);
        return dp[index];
    }
}
