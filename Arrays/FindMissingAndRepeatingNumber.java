package Arrays;

import java.util.HashSet;
import java.util.Set; 

public class FindMissingAndRepeatingNumber {
    public static void main(String[] args) {
        int[] arr = {1,1,3}; 
        int[] ans = findRepeatingAndMissingNumber(arr);
        for(int i : ans){
            System.out.print(i + " ");
        }
    } 
    //optimal aaproach; 
    public static int[] repeatingAndMissingNumber(int[] arr){
        int n = arr.length; 
        int sn = (n*(n+1))/2;
        int s2n = (n*(n+1)*(2*n+1))/6; 
        long sum = 0; 
        long sumOfSquares = 0; 
        for(int i = 0; i < n; i++){
            sum += arr[i]; 
            sumOfSquares += arr[i] * arr[i]; 
        }
        long val1 = sum - sn; 
        long val2 = sumOfSquares - s2n; 
        val2 = val2/val1; 
        long x = (val1 + val2)/2; 
        long y = val2 - x;  
        int[] ans = {(int)x, (int)y}; 
        return ans;
    }


    //better approach. 
    // using extra space but linear time complexity
    public static int[] findRepeatingAndMissingNumber(int[] arr){
        int[] ans = new int[2]; 
        Set<Integer> set = new HashSet<>(); 
        int sum = 0; 
        int n = arr.length; 
        int maxSum = (n*(n+1))/2;
        for(int i = 0; i < arr.length; i++){
            if(set.isEmpty() || !set.contains(arr[i])){
                set.add(arr[i]); 
                sum += arr[i]; 
            }
            else if(set.contains(arr[i])){
                ans[0] = arr[i]; 
                arr[i] = 0; 
                sum += arr[i]; 
            }
        }
        int diff = Math.abs(sum - maxSum); 
        ans[1] = diff; 
        return ans; 
    }

}
