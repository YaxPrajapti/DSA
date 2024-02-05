package Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5}; 
        int k = 2; 
        rotate(arr,k); 
        for(int i : arr){
            System.out.println(i);
        }
    }
    public static void rotate(int[] nums, int k){
        k = k % nums.length;
        int[] temp = new int[k];
        for(int i = nums.length - k; i < nums.length; i++){
            temp[i - (nums.length - k)] = nums[i];
        }
        for(int i = (nums.length-k)-1; i >= 0; i--){
            nums[i+k] = nums[i];
        }
        for(int i = 0; i < temp.length; i++){
            nums[i] = temp[i];
        }
    }
}
