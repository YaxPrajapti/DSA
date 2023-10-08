package Recursion.Basic;

public class PrintNameNTimes {
    public static void main(String[] args) {
        int n = 5; 
        int i = 0; 
        rec(i, n); 
    }
    public static void rec(int i, int n){
        if(i > n-1){
            return; 
        }
        System.out.println("Yax");
        rec(i+1, n);
    }
}
