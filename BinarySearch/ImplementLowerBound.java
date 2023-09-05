package BinarySearch;

public class ImplementLowerBound {
    public static void main(String[] args) {
        long[] arr = {1,2,8,10,11,12,19}; 
        int n = arr.length; 
        long x = 0; 
        int found = floorinSortedArr(arr, n, x); 
        System.out.println(found);
    }
    public static int floorinSortedArr(long[] arr, int n, long x){
        int l = 0; 
        int r = n - 1; 
        int ans = -1;
        while(l <= r){
            int mid = (int)(l + r)/2; 
            if(arr[mid] == x){
                return mid; 
            }else if(x < arr[mid]){
                r = mid-1; 
            }else if(x > arr[mid]){
                ans = mid; 
                l = mid + 1; 
            }
        }
        return ans; 
    }
}
