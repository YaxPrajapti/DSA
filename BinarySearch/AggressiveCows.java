package BinarySearch;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] stalls = {1,2, 4, 8, 9};
        int n = stalls.length; 
        int k = 3; 
        int ans = solve(n, k, stalls); 
        System.out.println(ans);
    }
    public static int solve(int n, int k, int[] stalls){
        Arrays.sort(stalls); 
        int mini = Integer.MAX_VALUE; 
        int maxi = Integer.MIN_VALUE; 
        for(int i : stalls){
            mini = Math.min(mini, i); 
            maxi = Math.max(maxi, i); 
        }
        int l = 1; 
        int h = maxi - mini; 
        int ans = -1; 
        while(l <= h){
            int mid = (int)(l + h)/2; 
            if(possible(stalls, k, mid)){
                l = mid + 1; 
                ans = Math.max(ans, mid); 
            }else{
                h = mid - 1; 
            }
        }
        return ans; 
    }
    private static boolean possible(int[] stalls, int cows, int dist){
        int countOfCows = 1; 
        int last = stalls[0]; 
        for(int i = 1; i < stalls.length; i++){
            if(stalls[i] - last >= dist){
                countOfCows++; 
                last = stalls[i]; 
            }
            if(countOfCows == cows){
                return true; 
            }
        }
        return false; 
    }
    
}
