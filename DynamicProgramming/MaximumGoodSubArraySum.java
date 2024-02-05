package DynamicProgramming;

public class MaximumGoodSubArraySum {
    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4};
        int k = 2;
        long ans = maximumSubarraySum(nums, k);
        System.out.println("ans = " + ans);
    }
    public static long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
//        long maxi = Long.MIN_VALUE;
//        for(int i = 0; i < n; i++){
//
//            for(int j = i; j < nums.length; j++){
//                long sum = 0;
//                boolean flag = false;
//                if(Math.abs(nums[j] - nums[i]) == k){
//                    flag = true;
//                    for(int z = i; z <= j; z++){
//                        sum += nums[z];
//                    }
//                }
//                if(flag){
//                    maxi = Math.max(maxi, sum);
//                }
//            }
//        }
//        return (maxi == Long.MIN_VALUE) ? 0 : maxi;
        return generate(0, nums, k, n);
    }
    private static long generate(int index, int[] nums, int k, int n){
        if(index == n){
            return 0;
        }
        long maxiSum = Long.MIN_VALUE;
        boolean flag = false;
        for(int i = index; i < n; i++){
            long sum = 0;
            if(Math.abs(nums[i] - nums[index]) == k){
                flag = true;
                for(int j = index; j <= i; j++){
                   sum+=nums[j];
                }
            }
            if(flag){
                maxiSum = Math.max(generate(index+1, nums, k, n), sum);
            }
        }
        return (maxiSum == Long.MIN_VALUE) ? 0 : maxiSum;
    }
}
