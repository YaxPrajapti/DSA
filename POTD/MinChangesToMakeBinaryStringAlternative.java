package POTD;

import javax.naming.ldap.ManageReferralControl;

public class MinChangesToMakeBinaryStringAlternative {
    public static void main(String[] args) {
        // String s = "0100"; 
        String s = "0100"; 
        int minChages = minOperations(s);
        System.out.println(minChages);
    }
    public static int minOperations(String s){
        int zeros = 0; 
        int ones = 0; 
        int balance = (int)Math.ceil(s.length()/2); 
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                zeros++; 
            }
            if(s.charAt(i) == '1'){
                ones++; 
            }
        }
        return Math.min(Math.abs(balance-ones), Math.abs(balance-zeros));
    }
    
    
}
