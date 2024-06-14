package BinarySearch;

public class SplitArray {
    public static void main(String[] args) {
        int[] arr = {6, 4, 5, 1, 5, 6, 6, 6, 5, 2}; 
        int k = 6; 
        int splitArray = splitArray(arr, k);
        System.out.println(splitArray);
    }
    public static int splitArray(int[] arr, int k){
        int mini = Integer.MIN_VALUE; 
        int maxSum = 0; 
        for(int i : arr){
            maxSum += i; 
            mini = Math.max(i, mini); 
        }
        int low = mini;
        int high = maxSum; 
        int ans = maxSum; 
        while(low <= high){
            int mid = (low + high) / 2;
            int partitions = findCount(arr, k, mid);
            if (partitions > k) {
                low = mid + 1;
            } else {
                ans = Math.min(ans, mid); 
                high = mid - 1;
            }
        } 
        return ans; 
    }
    private static int findCount(int[] arr, int k, int limit){
        int n = arr.length; //size of array.
        int partitions = 1;
        long subarraySum = 0;
        for (int i = 0; i < n; i++) {
            if (subarraySum + arr[i] <= limit) {
                subarraySum += arr[i];
            } else {
                partitions++;
                subarraySum = arr[i];
            }
        }
        return partitions;
    }
}
