package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/*
-> we will use the pick, not-pick approach. 
-> we can only pick if the last member of the data structure is smaller than the nums[index].
    -> carrying element in data structure will not work. Because in memoization approach. there could be more than one possiblities for the same length. So using length would be ambiguous. 
    -> use the previous index rather than the data structure because we need the count and we can do that easily. 
-> in the base case return the length of the data structure; 
-> we have to return the length; 
*/ 

public class LengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18}; 
        int ans = lengthOfLIS_optimized(nums); 
        System.out.println(ans);
    }

    public static int lengthOfLIS_optimized(int[] nums) {
        int n = nums.length; 
        int[] dp = new int[n]; 
        Arrays.fill(dp, 1); //there will be minimum length 1; 
        for(int i = 0; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                if(nums[prev] < nums[i]){
                    dp[i] = Math.max(1+dp[prev], dp[i]); 
                }
            }
        }
        //find the max out of the dp array. 
        int maxi = 1; 
        for(int i : dp){
            maxi = Math.max(maxi, i); 
        }
        return maxi; 
    }

    public static int lengthOfLIS(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n][n+1]; 
        for(int[] arr : dp){
            Arrays.fill(arr, -1); 
        }
        return solve(nums, new ArrayList<Integer>(), 0, n, dp); 
    }
    public static int solve(int[] nums, ArrayList<Integer> ans, int i, int n, int[][] dp){
        //base case 
        if(i == n){
            return ans.size(); 
        }
        if(dp[i][ans.size()] != -1){
            return dp[i][ans.size()]; 
        }
        //pick 
        int pick = 0; 
        if(ans.size() == 0 || ans.get(ans.size()-1) < nums[i]){
            ans.add(nums[i]); 
            pick = solve(nums, ans, i+1, n, dp); 
            ans.remove(ans.size()-1); 
        }
        //not-pick 
        int notpick = solve(nums, ans, i+1, n, dp); 
        return dp[i][ans.size()] = Math.max(pick, notpick); 
    }
}
