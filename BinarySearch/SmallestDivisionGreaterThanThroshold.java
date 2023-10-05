package BinarySearch;

public class SmallestDivisionGreaterThanThroshold {
    public static void main(String[] args) {
        int[] arr = {44,22,33,11,1}; 
        int throshold = 5; 
        int ans = smallestDivisior(arr, throshold); 
        System.out.println(ans);
    }
    public static int smallestDivisior(int[] arr, int throshold){
        int n = arr.length; 
        int maxi = Integer.MIN_VALUE; 
        for(int i = 0; i < n; i++){
            maxi = Math.max(maxi, arr[i]); 
        }
        int l = 1; 
        int h = maxi; 
        int ans = maxi; 
        while(l<=h){
            int mid = (int)(l+h)/2;
            int result = findsum(arr, mid); 
            if(result > throshold){
                l = mid + 1;  
            }else{
                h = mid - 1; 
                ans = Math.min(ans, mid);
            }
        }
        return ans; 
    }
    private static int findsum(int[] arr, int mid){
        int sum = 0; 
        for(int i = 0; i < arr.length; i++){
            sum = sum + (int)Math.ceil((double)arr[i]/mid);
        }
        return sum; 
    }
}
