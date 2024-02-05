package SlidingWindow;

public class MaxPointYouCanObtain {
    public static void main(String[] args) {
        int[] arr = {100,40,17,9,73,75};
        int k = 3;
        long startTime = System.nanoTime();
        int val = maxScore(arr, k);
        long endTime = System.nanoTime();
        long totalRunTime = endTime - startTime;
        System.out.println("val = " + val);
        System.out.println("totalRunTime = " + totalRunTime);
    }
    public static int maxScore(int[] cardPoints, int k){
        int sum = 0;
        int n = cardPoints.length;
        //sum of first k elements
        for(int i = 0; i < k; i++){
            sum += cardPoints[i];
        }
        //To select elements from the end of the array. we will need to drop the begining.
        int currSum = sum;
        for(int i = 0; i < k; i++){
            currSum = currSum - cardPoints[k-i-1] + cardPoints[n-1-i];
            sum = Math.max(sum, currSum);
        }
        return sum;
    }
}
