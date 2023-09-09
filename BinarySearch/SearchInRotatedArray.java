package BinarySearch;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] arr = {4,0,1,2,3}; 
        int target = 0; 
        int search = search(arr, target); 
        System.out.println(search);
    }
    public static int search(int[] arr, int target){
        int l =0;
        int r = arr.length - 1; 
        while(l <= r){
            int mid = (int)(l+r)/2; 
            if(arr[mid] == target){
                return mid; 
            }
            if(arr[l] <= arr[mid]){
                if(arr[l] <= target && target <= arr[mid]){
                    r = mid - 1; 
                }else{
                    l = mid + 1; 
                }
            }else {
                if(target >= arr[mid] && target <= arr[r]){
                    l = mid + 1; 
                }else {
                    r = mid - 1; 
                }
            }
        }
        return -1; 
    }
}
