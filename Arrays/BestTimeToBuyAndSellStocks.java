package Arrays;

public class BestTimeToBuyAndSellStocks {
    public static void main(String[] args) {
        int[] prices = {2,4,1}; 
        // int[] prices = {7,6,4,3,1};
        int profit = bestTime(prices); 
        System.out.println(profit);
    }
    //this is brute force approach
    public static int bestTime(int[] arr){
        int profit = 0; 
        for(int i = arr.length-1; i > 0; i--){
            for(int j = i-1; j >= 0; j--){
                profit = Math.max(profit, arr[i] - arr[j]); 
            }
        }
        return profit; 
    }
    //this is optimal approach
    public static int bestTimeTosell(int[] arr){
        int maxProfit = 0; 
        int minPrice = Integer.MAX_VALUE; 
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < minPrice){
                minPrice = arr[i]; 
            }
            maxProfit = Math.max(maxProfit, arr[i] - minPrice); 
        }
        return maxProfit; 
    }
}

