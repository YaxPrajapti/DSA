package Greedy;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {186,419,83,408}; 
        int amount = 6249; 
        int ans = coinChange(coins, amount); 
        System.out.println(ans);
    }
    public static int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        int count = 0; 
        Arrays.sort(coins); 
        int n = coins.length; 
        int i = n-1; 
        while(i >= 0){
            while(amount >= coins[i]){
                amount -= coins[i];
                count++; 
            }
            i--; 
        }
        return amount > 0 ? -1 : count; 
    }
}
