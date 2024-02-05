package Arrays;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] arr = {3,0,1};
        int missingNumber = findMissingNumber(arr); 
        System.out.println(missingNumber);
    }
    public static int findMissingNumber(int[] nums){
        int N = nums.length; 
        int sum = (N * (N + 1))/2; 
        int SUM = 0; 
        for(int i : nums){
            SUM = SUM + i; 
        }
        return Math.abs(sum - SUM); 
    }
}
