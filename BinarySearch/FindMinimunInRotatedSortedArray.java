package BinarySearch;

public class FindMinimunInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = { 1,2,3,4 };
        int min = findMinimum(arr);
        System.out.println(min);
    }

    public static int findMinimum(int[] arr) {
        int l = 0; 
        int r = arr.length-1; 
        int min = Integer.MAX_VALUE; 
        if(arr[l] <= arr[r]){
            return arr[l]; 
        }
        while(l <= r){
            int mid = (int)(l+r)/2; 
            //check if the array is sorted. 
            //first half is sorted
            if(arr[l] <= arr[mid]){
                min = Math.min(min, arr[l]); 
                l = mid + 1; 
            }
            //second half is soted. 
            else {
                min = Math.min(mid, arr[mid+1]); 
                r = mid; 
            }
        }
        return min; 
    }
}
