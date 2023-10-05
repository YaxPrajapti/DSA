package BinarySearch;

public class Sqrt {
    public static void main(String[] args) {
        int x = 50; 
        System.out.println(sqrt(x));
    }
    public static long sqrt(long x ){
        long low = 1; 
		long high = x; 
		long ans = 1; 
		while(low <= high){
		    long mid = (long)(low + high)/2; 
		    if((mid * mid) <= x){
		        ans = mid; 
		        low = mid + 1; 
		    }else{
		        high = mid - 1; 
		    }
		}
		return ans; 
    }
}
