package POTD;

import java.util.ArrayList;
import java.util.Collections;

/**
 * InnerBuyMaxStocks
 */
class Stock implements Comparable<Stock>{
    int day; 
    int price; 
    Stock(int day, int price){
        this.day = day; 
        this.price = price; 
    }
    @Override
    public int compareTo(Stock s){
        return Integer.compare(this.price, s.price); 
    }
}
public class BuyMaxStocks {
    public static void main(String[] args) {
        int[] prices = {7,10,4}; 
        int k = 100; 
        int n = prices.length; 
        int count = buyMaximumProducts(n, k, prices);
        System.out.println(count);
        
    }
    public static int buyMaximumProducts(int n, int k, int[] prices){
        ArrayList<Stock> stocks = new ArrayList<>(); 
        int purchasedStock = 0; 
        for(int i = 0; i < prices.length; i++){
            stocks.add(new Stock(i+1, prices[i])); 
        }
        Collections.sort(stocks); 
        for(int i = 0; i < stocks.size(); i++){
            System.out.println("day: " + stocks.get(i).day + " stock price: " + stocks.get(i).price);
        }
        for(int i = 0; i < stocks.size(); i++){
            int stockCount = 0; 
            Stock s = stocks.get(i); 
            while(stockCount < s.day && k >= s.price){
                stockCount++; 
                purchasedStock++; 
                k = k - s.price; 
            }
            System.out.println("Day: " + s.day + " purchased: "+ stockCount);
        }
        return purchasedStock; 
    }
}
