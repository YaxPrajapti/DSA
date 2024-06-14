package Arrays;

import java.util.HashMap;

public class LongestSubArraywithSumDivisibleByk {
    public static void main(String[] args) {
        int[] arr = {-1, 9, 0}; 
        int n = arr.length; 
        int k = 9; 
        int len = longSubarrWthSumDivByK(arr, n, k); 
        System.out.println(len);
    }
    public static int longSubarrWthSumDivByK(int[] arr, int n, int k){
        int maxlen = 0; 
        HashMap<Integer, Integer> map = new HashMap<>(); 
        int sum = 0; 
        for(int i = 0; i < n; i++){
            sum += arr[i]; 
            int rem = sum % k; 
            if(rem == 0){
                maxlen = Math.max(maxlen, i+1); 
            }
            if(rem < 0){
                rem = rem + k; 
            }
            if(map.containsKey(rem)){
                int len = i - map.get(rem); 
                maxlen = Math.max(len, maxlen); 
            }
            if(!map.containsKey(rem)){
                map.put(rem, i); 
            }
        }
        return maxlen; 
    }
}
