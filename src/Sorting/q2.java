package Sorting;

import java.util.ArrayList;
import java.util.List;

public class q2 {
    public static void main(String[] args) {
        int n = 3; 
        List<String> res = validStrings(n); 
        System.out.println(res);
    }
    public static List<String> validStrings(int n) {
        List<String> result = new ArrayList<>(); 
        func(n, result, new StringBuilder()); 
        return result; 
    }
    public static void func(int n , List<String> result, StringBuilder sb){
        if(sb.length() == n){
            result.add(new String(sb.toString())); 
            return; 
        }
        if(sb.length() == 0 || sb.charAt(sb.length()-1) == '1'){
            sb.append('1'); 
            func(n, result, sb); 
            sb.deleteCharAt(sb.length()-1);
            sb.append('0'); 
            func(n, result, sb); 
            sb.deleteCharAt(sb.length()-1);
        }else if(sb.charAt(sb.length()-1) == '0'){
            sb.append('1'); 
            func(n, result, sb); 
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
