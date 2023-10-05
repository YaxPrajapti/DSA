package BinarySearch;

public class CountOccurance {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3};  
        int n = arr.length; 
        int x = 2; 
        int count = count(arr, n, x); 
        System.out.println(count);
    }
    public static int count(int[] arr, int n, int x){
        int l = 0; 
        int r = arr.length-1; 
        int ans = 0; 
        while(l <= r){
            int mid = (int)(l+r)/2; 
            if(arr[mid] == x){
                int backwards = mid; 
                int forward = mid; 
                while(backwards >= 0 && arr[backwards] == x){
                    backwards--; 
                }
                while(forward < arr.length && arr[forward] == x){
                    forward++; 
                }
                ans = forward - backwards - 1; 
                return ans; 
            }
            else if(x < arr[mid]){
                r = mid - 1; 
            }
            else if(x > arr[mid]){
                l = mid + 1; 
            }
        }
        return ans; 
    }
}
