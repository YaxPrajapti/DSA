package SlidingWindow;

public class CountNumberOfNiceSubArrays {
    public static void main(String[] args) {
        int[] arr = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        int numberOfSubarrays = numberOfSubarrays(arr, k);
        System.out.println("numberOfSubarrays = " + numberOfSubarrays);
    }
    public static int numberOfSubarrays(int[] nums, int k){
        int start = 0;
        int end = 0;
        int countOfOdd = 0;
        int ans = 0;
        int n = nums.length;
        int temp = 0;
        while (end < n){
            if(nums[end] % 2 == 1){
                countOfOdd++;
                temp = 0;
            }
            while (countOfOdd == k && start <= end){
                temp++;
                if (nums[start] % 2 == 1){
                    countOfOdd--;
                }
                start++;
            }
            ans+=temp;
            end++;
        }
        return ans;
    }
}
