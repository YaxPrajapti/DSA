package POTD;

public class SmallestSubString {
    public static void main(String[] args) {
        String s = "121212"; 
        int len = smallestSubstring(s); 
        System.out.println(len);
    }
    public static int smallestSubstring(String S){
        int zero = -1; 
        int one = -1; 
        int two = -1; 
        int len = Integer.MAX_VALUE; 
        for(int i = 0; i < S.length(); i++){
            char ch = S.charAt(i); 
            if(ch == '0'){
                zero = i;  
            }
            if(ch == '1'){
                one = i; 
            }
            if(ch == '2'){
                two = i; 
            }
            if(zero != -1 && one != -1 && two != -1){
                int min = Math.min(Math.min(zero, one), two); 
                int max = Math.max(Math.max(zero, one), two); 
                len = Math.min(len, max-min+1); 
            }
        }
        return (len == Integer.MAX_VALUE) ? -1 : len; 
    }
}
