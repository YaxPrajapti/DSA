package BinarySearch;

import Arrays.sort2DArray;

public class CapacityToLoadWeight {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10}; 
        int days = 5; 
        int ans = shipWithinDays(weights, days); 
        System.out.println(ans);
    }
    public static int shipWithinDays(int[] weights, int days){
        int maxWeight = 0; 
        int min = Integer.MIN_VALUE; 
        for(int i : weights){
            min = Math.max(min, i); 
            maxWeight += i; 
        }
        int l = min; 
        int h = maxWeight; 
        while(l <= h){
            int mid = (int)(l+h)/2; 
            boolean possible = possible(weights, days, mid); 
            if(possible){
                h = mid - 1; 
            }else{
                l = mid + 1; 
            }
        }
        return l; 
    }
    private static boolean possible(int[] weights, int days, int capacity){
        int day = 1; 
        int w = 0; 
        for(int i = 0; i < weights.length; i++){
            if(w + weights[i] > capacity){
                w = weights[i];
                day+=1; 
            }else{
                w += weights[i];
            }
        }
        return (day <= days) ? true : false; 
    }
}
