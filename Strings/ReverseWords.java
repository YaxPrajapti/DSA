package Strings;

import java.util.ArrayList;
import java.util.List;
import java.lang.Character;

public class ReverseWords {
    public static void main(String[] args) {
        String s = "the sky is blue"; 
//        String reversedWords = reverseString(s);
//        System.out.println(reversedWords);
    }
    
    
    /*
    public static String reverseString(String s){
        s = s.trim();   
        StringBuilder st = new StringBuilder();
        List<String> strings = new ArrayList<>();  
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i); 
            if(ch != ' '){
                st.append(ch); 
            }else if(ch == ' '){
                if(s.charAt(i-1) == ' '){
                    continue; 
                }
                strings.add(st.toString()); 
                // System.out.println("Present st: " + st);
                st.delete(0, st.length());
            }
            if(i == s.length()-1){
                strings.add(st.toString()); 
                st.delete(0, st.length());
            }
        } 
        StringBuilder ans = new StringBuilder(); 
        System.out.println("List of sub strings: "  + strings);
        for(int i = strings.size()-1; i >= 0; i--){
            ans.append(strings.get(i)); 
            ans.append(" ");
        }
        return ans.toString().trim(); 
    }
     */
}
