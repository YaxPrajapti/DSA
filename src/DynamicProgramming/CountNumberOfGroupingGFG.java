package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class CountNumberOfGroupingGFG {
    public static void main(String[] args) {
        String str = "1119";
        int count = TotalCount(str);
        System.out.println(count);
    }
    public static int TotalCount(String str){
        int index = 0;
        int sum = 0;
        int[][] dp = new int[str.length()][9*str.length()];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return grouping(index, sum, dp, str);
    }
    private static int grouping(int index, int sum, int[][] dp, String str){
        if(index == str.length()){
            return 1;
        }
        if(dp[index][sum] != -1){
            return dp[index][sum];
        }
        int currentSum = 0;
        int ans = 0;
        for(int i = index; i < str.length(); i++){
            currentSum += str.charAt(i) - '0';
            if(currentSum >= sum){
                ans+=grouping(i+1, currentSum, dp, str);
            }
        }
        dp[index][sum] = ans;
        return dp[index][sum];
    }
}
