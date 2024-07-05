package BitManipulation;

public class SingleNumber3 {
    public static void main(String[] args) {
        int[] nums = {-1, 0}; 
        int[] ans = singleNumber(nums); 
        for(Integer i : ans){
            System.out.print(i + " ");
        }
    }
    public static int[] singleNumber(int[] nums) {
        int xor = 0; 
        for(Integer i : nums){
            xor ^= i; 
        }
        int right_set_bit = 0; 
        for(int i = 0; i < 32; i++){
            if((xor & (1 << i)) != 0){
                right_set_bit = i; 
                break; 
            }
        }
        int a = 0; 
        int b = 0; 
        for(Integer i : nums){
            if((i & (1 << right_set_bit)) != 0) {
                a ^= i; 
            }else {
                b ^= i; 
            }
        }
        return new int[]{a,b}; 
    }
}
