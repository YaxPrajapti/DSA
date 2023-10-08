package Recursion.Basic;

public class PrintLinear {
    public static void main(String[] args) {
        int num = 1; 
        int end = 10; 
        rec(num, end);
    }
    public static void rec(int num, int end){
        if(num > end){
            return; 
        }
        System.out.print(num + " ");
        rec(num+1, end); 
    }
}
