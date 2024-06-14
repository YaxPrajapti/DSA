package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class SubString {
    public static void main(String[] args) {
        String s = "abc"; 
        List<List<String>> subString = substrings(s); 
        System.out.println(subString);
    }
    public static List<List<String>> substrings(String s){
        int index = 0; 
        List<List<String>> ans = new ArrayList<>(); 
        generate(s, index, ans, new StringBuilder());
        return ans; 
    }
    private static void generate(String s, int index, List<List<String>> ans, StringBuilder ds){
        if(index == s.length()){
            List<String> temp = new ArrayList<>(); 
            temp.add(ds.toString()); 
            ans.add(new ArrayList<>(temp)); 
            return; 
        }
        ds.append(s.charAt(index)); 
        generate(s, index+1, ans, ds);
        ds.deleteCharAt(ds.length()-1); 
        generate(s, index+1, ans, ds);
    }
}
