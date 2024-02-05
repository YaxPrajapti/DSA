package Recursion.Hard;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 3; 
        System.out.println(climb(n));
    }
    public static int climb(int n){
        int[] count = {0}; 
        helpr(n, count); 
        return count[0]; 
    }
    private static void helpr(int n, int[] count){
        if(n == 0 || n == 1){
            count[0]++; 
            return; 
        }
        helpr(n-1, count);
        helpr(n-2, count); 
    }
}
