package Arrays;

import java.util.HashMap;

public class MaximumGoodSubArraySum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        int k = 1;
        long maximumSubarraySum = maximumSubarraySum(nums, k);
        System.out.println("maximumSubarraySum = " + maximumSubarraySum);
    }
    public static long maximumSubarraySum(int[] nums, int k){
        HashMap<Integer, Long> map = new HashMap<>();
        int n = nums.length;
        long[] sums = new long[n+1];
        Long ans = Long.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            sums[i+1] = sums[i] + nums[i];
            if(!map.containsKey(nums[i])){
                map.put(nums[i], sums[i]);
            }else{
                map.put(nums[i], Math.min(sums[i], map.get(nums[i])));
            }
            if(map.containsKey(nums[i] - k)){
                ans = Math.max(ans, sums[i+1] - map.get(nums[i]-k));
            }
            if(map.containsKey(nums[i] + k)){
                ans = Math.max(ans, sums[i+1]-map.get(nums[i]+k));
            }
        }
        return (ans == Long.MIN_VALUE) ? 0 : ans;
    }
}
