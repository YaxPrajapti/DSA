package Recursion.Basic;

public class FibSeries {
    public static void main(String[] args) {
        int num = 5; 
        int ans = fib(num); 
        System.out.println(ans);
    }
    public static int fib(int num){
        if(num <= 1){
            return num; 
        }
        return fib(num-1) + fib(num-2); 
    }
    
}
