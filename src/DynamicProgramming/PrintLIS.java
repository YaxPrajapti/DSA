package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintLIS {
    public static void main(String[] args) {
        int[] arr = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15}; 
        int n = arr.length; 
        ArrayList<Integer> ans = longestIncreasingSubsequence(n, arr); 
        System.out.println(ans);
    }
    public static ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
        // Code here
        int[] dp = new int[n]; 
        int[] hash = new int[n]; 
        Arrays.fill(dp, 1); 
        int maxi = 1; 
        int last = 0; 
        for(int i = 0; i < n; i++){
            hash[i] = i; 
            for(int prev = 0; prev < i; prev++){
                if(arr[prev] < arr[i] && 1+dp[prev] > dp[i]){
                    hash[i] = prev; 
                    dp[i] = 1 + dp[prev];  
                }
            }
            if(dp[i] > maxi){
                maxi = dp[i]; 
                last = i; 
            }
        }
        ArrayList<Integer> list = new ArrayList<>(); 
        list.add(0, arr[last]); 
        while(hash[last] != last){
            last = hash[last]; 
            list.add(0, arr[last]); 
        }
        return list; 
    }
}
