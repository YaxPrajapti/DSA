package Recursion.Basic;

public class PalindromString {
    public static void main(String[] args) {
        String s = "MADA"; 
        int n = s.length(); 
        isPalindrom(s, n);
    }
    public static void isPalindrom(String s, int n){
        check(s, n , 0); 
    }
    private static void check(String s, int n, int i){
        if(i > n/2){
            System.out.println("Yes");
            return; 
        }
        if(s.charAt(i) != s.charAt(n-i-1)){
            System.out.println("No");
            return; 
        }
        check(s, n, i+1);
    }
}
