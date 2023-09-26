package BinarySearch;

public class FindMinimunInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = { 66, 67, 7, 10, 14, 19, 27, 33, 36, 40, 44, 54, 60 };
        int min = findMinimum(arr);
        // System.out.println(min);
        System.out.println(findMinIndex(arr));
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
    public static int findMinIndex(int[] arr){
        int n = arr.length; 
        int l = 0; 
        int r = n - 1; 
        int minIndex = 0; 
        if(arr[l] <= arr[r]){
            return l; 
        }
        while(l <= r){
            int mid = (int)(l + r)/2; 
            if(arr[l] <= arr[mid]){
                 if(arr[l] <= arr[minIndex]){
                    minIndex = l; 
                 }
                 l = mid+1; 
            }else{
                if(arr[mid+1] < arr[minIndex]){
                    minIndex = mid+1; 
                }
                r = mid; 
            }
        }
        return minIndex; 
    }
}
