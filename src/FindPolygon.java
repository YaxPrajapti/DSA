import java.util.Arrays;

public class FindPolygon {
    public static void main(String[] args) {
        int[] arr = {5,5,50};
        long ans = largestPerimeter(arr);
        System.out.println("ans = " + ans);
    }
    public static long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long[] prefixSum = new long[nums.length];
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum+=nums[i];
            prefixSum[i] = sum;
        }
//        int index = -1;
        long ans = 0; 
        for(int i = 2; i < prefixSum.length; i++){
            if(prefixSum[i-1] > nums[i]){
                ans = prefixSum[i];
            }
        }
        return ans == 0 ? -1 : ans;
    }
}
