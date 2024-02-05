package BinarySearch;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6}; 
        int target = 7; 
        int n = arr.length; 
        int pos = serachInsertPos(arr, target, n); 
        System.out.println(pos);
    }
    public static int serachInsertPos(int[] arr, int target, int n){
        int l = 0; 
        int r = n - 1; 
        int ans = -1; 
        if(target > arr[r]){
            return n; 
        }
        while(l <= r){
            int mid = (int)(l+r)/2; 
            if(arr[mid] == target){
                return mid; 
            }else if(target < arr[mid]){
                ans = mid; 
                r = mid-1; 
            }else if(target > arr[mid]){
                l = mid+1; 
            }
        }
        return ans; 
    }
}
