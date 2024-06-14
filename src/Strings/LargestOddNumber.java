package Strings;

public class LargestOddNumber {
    public static void main(String[] args) {
        String s = "22"; 
        String largestOddNumber = largetstOddNumber(s); 
        System.out.println(largestOddNumber); 
    }
    public static String largetstOddNumber(String s){
        int index = s.length()-1;
        while (index >= 0) {
            char ch = s.charAt(index); 
            int num = ch; 
            if(num % 2 == 1){
               return s.substring(0, index+1); 
            }
            index--; 
        }
        return ""; 
    }
    
   
}
