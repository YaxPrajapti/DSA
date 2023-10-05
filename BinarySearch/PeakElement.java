package BinarySearch;

public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {1,2,1,3}; 
        int peakElement = peakIndex(arr); 
        System.out.println(peakElement);
    }
    public static int peakIndex(int[] arr){
        int n = arr.length; 
        if(n == 1){
            return 0; 
        }
        if(arr[0] > arr[1]){
            return 0; 
        }
        if(arr[n-1] > arr[n-2]){
            return n-1; 
        }
        int l = 1; 
        int r = n-2; 
        while(l <= r){
            int mid = (int)(l+r)/2; 
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return mid; 
            }
            if(arr[mid+1] > arr[mid]){  
                l = mid + 1; 
            }else{
                r = mid - 1; 
            }
        }
        return 0; 
    }
}
