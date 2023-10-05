package BinarySearch;

public class KthPositiveMissingNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4}; 
        int k = 2; 
        int missingNumber = findKthPositive(arr, k); 
        System.out.println(missingNumber);
    }
    public static int findKthPositive(int[] arr, int k){
        int l = 0; 
        int h = arr.length-1; 
        while(l <= h){
            int mid = (int)(l+h)/2; 
            int missingNumber = arr[mid] - (mid + 1); 
            if(k > missingNumber){
                l = mid + 1; 
            }else{
                h = mid - 1; 
            }
        }
        return k + h + 1; 
    }
}
