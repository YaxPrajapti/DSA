package POTD;

public class LargestSumSubarrayOfKElements {
    public static void main(String[] args) {
        // long[] arr = {1, -2, 2, -3}; 
        long[] arr = {1,1,1,1,1,1}; 
        long k = 2; 
        long n = arr.length;
        long max_sum = maxSumWithK(arr, n, k); 
        System.out.println(max_sum);
    }
    public static long maxSumWithK(long[] a, long n, long k){
        long sum=0; 
        long max = 0; 
        long prev = 0; 
        int i = 0; 
        int j = 0; 
        while (i < k) {
            sum = sum + a[i];
            i++; 
        }
        max = sum; 
        while (i < n) {
            sum = sum + a[i];
            prev = prev + a[j]; 
            i++; 
            j++; 
            max = Math.max(max, sum); 
            if(prev < 0){
                sum = sum - prev; 
                prev = 0; 
                max = Math.max(sum, max); 
            }
        }

        return max; 
    }
}
