package Strings;

import java.util.ArrayList;
import java.util.List;
import java.lang.Character;

public class ReverseWords {
    public static void main(String[] args) {
        String s = "a good   example";
        String reversedWords = reverseString(s);
        System.out.println(reversedWords);
    }
    
    public static String reverseString(String s){
        int i = s.length()-1;
        s.trim();
        StringBuilder sb = new StringBuilder();
        while (i >= 0){
            int j = i;
            while (i>=0 && s.charAt(i) != ' '){
                i--;
            }
            sb.append(s.substring(i+1,j+1));
            sb.append(" ");
            while (i>=0 && s.charAt(i) == ' '){
                i--;
            }

        }
        return sb.toString().trim();
    }

}
