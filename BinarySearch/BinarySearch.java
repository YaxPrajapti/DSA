package BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12}; 
        int target = 9; 
        int index = binarySearch(arr, target); 
        System.out.println(index);
    }
    public static int binarySearch(int[] arr, int target){
        int n = arr.length; 
        int l = 0; 
        int r = n-1; 
        while(l < r){
            int mid = (int) (l + r)/2; 
            if(arr[mid] == target){
                return mid; 
            }else if(target > arr[mid]){
                l = mid + 1; 
            }else if(target < arr[mid]){
                r = mid - 1; 
            }
        }
        return -1; 
    }
}
