package Arrays;


public class KadaneAlgo {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4}; 
        int maxSum = findMaximumSumSubArray(arr);
        System.out.println(maxSum);
        findMaxSumSubArrayList(arr); 
    }
    public static int findMaximumSumSubArray(int[] arr){
        int maxi = Integer.MIN_VALUE; 
        int sum = 0; 
        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i]; 
            if(sum > maxi){
                maxi = sum; 
            }
            if(sum < 0){
                sum = 0; 
            }
        }
        return maxi; 
    }
    public static void findMaxSumSubArrayList(int[] arr){
        int maxi = Integer.MIN_VALUE; 
        int sum = 0; 
        int start = 0; 
        int ansStart = -1; 
        int ansEnd = -1; 

        for(int i = 0; i < arr.length; i++){
            if(sum == 0){
                start = i; 
            }
            sum = arr[i] + sum; 
            if(sum > maxi){
                ansStart = start; 
                ansEnd = i; 
                maxi = sum; 
            }
            if(sum < 0){
                sum = 0; 
            }
        }
        
        System.out.println();
        for(int i = ansStart; i <= ansEnd; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
