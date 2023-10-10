package BinarySearch;

public class FirstAndLastOccurance {
    public static void main(String[] args) {
        int[] arr = {1}; 
        int n = arr.length; 
        int x = 1; 
        int[] ans = firstAndLastPos(arr, x); 
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
    public static int[] firstAndLastPos(int[] arr, int x){
        int l = 0; 
        int r = arr.length-1; 
        int[] ans = {-1,-1};
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
                ans[0] = backwards+1; 
                ans[1] = forward-1;
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
