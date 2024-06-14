package SlidingWindow;

public class MaxConsecutiveOnes3 {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        int size = longestOnes(arr, k);
        System.out.println(size);
    }

    public static int longestOnes(int[] arr, int k) {
        int start = 0;
        int end = 0;
        int len = 0;
        int maxi = 0;
        while (end < arr.length) {
            if (arr[end] == 1) {
                end++;
                len = end - start;
                maxi = Math.max(len, maxi);
            } else {
                if (k > 0) {
                    end++;
                    len = end - start;
                    maxi = Math.max(len, maxi);
                    k--;
                } else {
                    while (arr[start] == 1) {
                        start++;
                        len = end - start;
                    }
                    start++;
                    k++;
                }
            }
        }
        return maxi;
    }

}
