package SlidingWindow;

/**
 * LongestContinousSubArrayWithDiff
 */
public class LongestContinousSubArrayWithDiff {

    public static void main(String[] args) {
        int[] nums = {8,2,4,7}; 
        int limit = 4; 
        int ans = longestSubarray(nums, limit); 
        System.out.println(ans);
    }
    public static int longestSubarray(int[] nums, int limit) {
        int count = 0; 
        int len = 0; 
        int diff = 0; 
        int n = nums.length;
        for(int i =0; i < n; i++){
            int maxi = nums[i]; 
            int mini = nums[i];
            for(int j = i; j < n; j++){
                maxi = Math.max(maxi, nums[j]); 
                mini = Math.max(mini, nums[j]); 
                diff = Math.abs(maxi- mini);
                if(diff <= limit){
                    if(j-i+1 > len){
                        len = j-i+1; 
                        count=1; 
                    }else if(j-i+1 == len){
                        count++; 
                    }
                }
            }
        }
        return count; 
    }
}