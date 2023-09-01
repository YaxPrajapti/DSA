package Arrays;

import java.util.HashMap;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {2,0,0,3};
        int k = 3; 
        int n = arr.length; 
        int lognestSubarr = longestSubarraywithsumk(arr, n, k); 
        System.out.println(lognestSubarr);
    }
    public static int longestSubarraywithsumk(int[] arr, int n, int k){
        int maxlen = 0; 
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0; 
        for(int i = 0; i < n; i++){
            sum = sum + arr[i]; 
            if(sum == k){
                maxlen = Math.max(maxlen, i+1); 
            }
            int rem = sum - k; 
            if(map.containsKey(rem)){
                int len = i - map.get(rem); 
                maxlen = Math.max(maxlen, len); 
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxlen; 
    }
    public static int longestSubarrayPositiveOnly(int[] arr, int n, int k){
        int left = 0; 
        int right = 0; 
        int sum = arr[0]; 
        int maxlen = 0; 
        while(right < n){
            while(left <= right && sum > k){
                sum = sum - arr[left]; 
                left++; 
            }
            if(sum == k){
                maxlen = Math.max(maxlen, right - left + 1);  
            }
            right++; 
            if(right < n){
                sum = sum + arr[right];
            }
        }
        return maxlen; 
    }
}

