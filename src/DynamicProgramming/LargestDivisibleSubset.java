package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        // int[] arr = {1,2,4,8}; 
        int[] arr = {1,2,3}; 
        List<Integer> ans = largestDivisibleSubset(arr); 
        System.out.println(ans);
    }
    public static List<Integer> largestDivisibleSubset(int[] arr){
        Arrays.sort(arr);
        int n = arr.length; 
        int[] dp = new int[n]; 
        Arrays.fill(dp, 1); 
        int[] hash = new int[n]; 
        int maxi = 1; 
        int last = 0; 
        for(int i = 0; i < n; i++){
            hash[i] = i; 
            for(int prev = 0; prev < i; prev++){
                if(arr[i] % arr[prev] == 0 && 1+dp[prev] > dp[i]){
                    hash[i] = prev; 
                    dp[i] = 1+dp[prev];
                }
            }
            if(dp[i] > maxi){
                last = i; 
                maxi = dp[i]; 
            }
        }
        ArrayList<Integer> list = new ArrayList<>(); 
        list.add(0, arr[last]); 
        while (hash[last] != last) {
            last = hash[last]; 
            list.add(0, arr[last]); 
        }
        return list; 
    }
}
