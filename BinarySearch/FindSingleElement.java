package BinarySearch;

public class FindSingleElement {
    public static void main(String[] args) {
        int[] arr = {3,3,7,7,10,11,11}; 
        int ans = singleElement(arr); 
        System.out.println(ans);
    }
    public static int singleElement(int[] arr){
        int n = arr.length; 
        //check for edge cases, 
        if(n == 1){
            return arr[0]; 
        }
        if(arr[0] != arr[1]){
            return arr[0]; 
        }
        if(arr[n-1] != arr[n-2]){
            return arr[n-1]; 
        }
        int low = 1; 
        int high = n-2; 
        while(low <= high){
            int mid = (int)(low+high)/2; 
            //check if the mid element is single element; 
            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]){
                return arr[mid]; 
            }
            //elimination part
            //if we are at left part of the single element then pairing migh look like even-odd
            if((mid % 2 == 1 && arr[mid] == arr[mid-1]) || (mid % 2 == 0 && arr[mid] == arr[mid+1])){
                low = mid + 1; 
            }
            //we are in the right portion
            else{
                high = mid - 1; 
            }
        }
        return -1; 
    }
}
