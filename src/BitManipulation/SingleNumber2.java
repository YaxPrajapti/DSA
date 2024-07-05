package BitManipulation;

public class SingleNumber2 {
    public static void main(String[] args) {
        int[] nums = {30000,500,100,30000,100,30000,100}; 
        int ans = singleNumber(nums); 
        System.out.println(ans);
    }

    public static int singleNumber(int[] nums) {
        int n = nums.length;
        int ans = 0; 
        for (int i = 0; i < 32; i++) {
            int ones = 0;
            int zeros = 0;
            for (int j = 0; j < n; j++) {
                if ((nums[j] & (1 << i)) != 0) {
                    ones+=1;
                } else {
                    zeros+=1; 
                }
            }
            if (ones % 3 != 0) {
                ans |= (1 << i); 
            }else{
                ans |= 0; 
            }
        }
        return ans; 
    }

}
