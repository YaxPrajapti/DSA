package DynamicProgramming;

import java.util.Arrays;

public class NumberOfLIS {
    public static void main(String[] args) {
        int[] nums = {1,3,2,4}; 
        int ans = findNumberOfLIS(nums); 
        System.out.println(ans);
    }
    public static int findNumberOfLIS(int[] nums){
        int n = nums.length; 
        int[] dp = new int[n]; 
        int[] count = new int[n]; 
        Arrays.fill(dp, 1); 
        Arrays.fill(count, 1); 
        int maxi = 1; 
        for(int i = 0; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                if(nums[prev] < nums[i]){
                    if(dp[prev] + 1 == dp[i]){
                        count[i] = count[i] + count[prev];                                      
                    }else if(dp[prev] + 1 > dp[i]){
                        dp[i] = dp[prev] + 1; 
                        count[i] = count[prev];      
                    }
                }
                maxi = Math.max(maxi, dp[i]); 
            }
        }
        for(int i = 0; i < n; i++){
            System.out.print("dp[i] : " + dp[i]);
            System.out.println(" count[i] : "+ count[i]);
            System.out.println();
        }
        int number = 0; 
        for(int i = 0; i < n; i++){
            if(dp[i] == maxi){
                number += count[i]; 
            }
        }
        return number; 
    }
}
