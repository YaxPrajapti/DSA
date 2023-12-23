package POTD;

/*
 * You are given an integer array prices representing the prices of various chocolates in a store. You are also given a single integer money, which represents your initial amount of money.

You must buy exactly two chocolates in such a way that you still have some non-negative leftover money. You would like to minimize the sum of the prices of the two chocolates you buy.

Return the amount of money you will have leftover after buying the two chocolates. If there is no way for you to buy two chocolates without ending up in debt, return money. Note that the leftover must be non-negative.


 */
public class BuyTwoChocolates {
    public static void main(String[] args) {
        int[] prices = {41,1,28,2,92,97,1,87}; 
        int money = 68; 
        int res = buyChoco(prices, money); 
        System.out.println(res);
    }
    public static int buyChoco(int[] prices, int money){
        int min = Integer.MAX_VALUE;  
        int secMin = min; 
        for(int x : prices){
            if(x == min){
                secMin = min; 
            }
            if(x < min){
                secMin = min; 
                min = x; 
            }
            else if(x < secMin && x > min){
                secMin = x; 
            }
        }
        System.out.println("Min: "+ min);
        System.out.println("Second min: " + secMin);
        int leftOver = money - (secMin + min); 
        return (leftOver < 0) ? money : leftOver; 
    }

}
