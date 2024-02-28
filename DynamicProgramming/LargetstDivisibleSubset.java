package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargetstDivisibleSubset {
    public static void main(String[] args) {
        int[] nums = {3,4,16,8};
        List<Integer> ans = largestDivisibleSubset(nums);
        System.out.println(ans);
    }
    //tabulation
    public static List<Integer> largestDivisibleSubset(int[] nums){
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] prevIndex = new int[n];
        Arrays.fill(prevIndex, -1);
        int last_chosen_index = 0;
        int max_length = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i]%nums[j] == 0){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        prevIndex[i] = j;
                    }
                    if(dp[i] > max_length){
                        max_length = dp[i];
                        last_chosen_index = i;
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (last_chosen_index >= 0){
            result.add(nums[last_chosen_index]);
            last_chosen_index = prevIndex[last_chosen_index];
        }
        return result;
    }

    /*
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int prev = -1; //prev element OR last element of temp. This will check if the element of nums is divisible by the last picked element or not.
        helper(0, nums, result, new ArrayList<Integer>(), prev);
        return result;
    }
    */


    /*basic recursion
    public static void helper(int index, int[] nums, List<Integer> result, ArrayList<Integer> temp, int prev){
        if(index >= nums.length){
            if(temp.size() > result.size()){
                result.clear();
                result.addAll(temp);
            }
            return;
        }
        //pick
        if(prev == -1 || nums[index] % prev == 0 || prev % nums[index] == 0){
            temp.add(nums[index]);
            helper(index+1, nums, result, temp, nums[index]);
            temp.remove(temp.size()-1);
        }
        //not pick
        helper(index+1, nums, result, temp, prev);
    }
    */
}
