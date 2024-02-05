package POTD;

public class SplitArray {
    public static void main(String[] args) {
        int[] arr = { 6, 4, 5, 1, 5, 6, 6, 6, 5, 2 };
        int N = arr.length;
        int k = 6;
        int count = splitArray(arr, N, k);
        System.out.println(count);
    }

    public static int splitArray(int[] arr, int N, int k) {
        int low = arr[0];
        int high = 0;
        for (int i = 0; i < N; i++) {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }
        int ans = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            int partitions = countPartitions(k, mid, arr);
            if(partitions > k){
                low = mid + 1; 
            }else{
                ans = Math.min(ans, mid); 
                high = mid-1; 
            }
        }
        return ans;
    }

    private static int countPartitions(int k, int max_sum, int[] arr) {
        int sum = 0;
        int partitions = 1;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= max_sum) {
                sum += arr[i];
            } else {
                partitions++;
                sum = arr[i];
            }
        }
        return partitions;
    }
}
