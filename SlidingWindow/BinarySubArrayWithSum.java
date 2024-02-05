package SlidingWindow;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;

public class BinarySubArrayWithSum {
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal = 2;
        int ans = numSubarraysWithSum(nums, goal);
        System.out.println("ans = " + ans);
    }
    public static int numSubarraysWithSum(int[] nums, int k){
        int i = 0;
        int j = 0;
        int count = 0;
        int sum = 0;
        int temp = 0;
        while (j < nums.length){
            sum += nums[j];
            if(nums[j] == 1){
                temp = 0;
            }
            while (sum > k){
                sum -= nums[i];
                i++;
            }
            while (sum == k && i <= j){
                temp++;
                sum -= nums[i];
                i++;
            }
            j++;
            count += temp;
        }
        return count;
    }
}
