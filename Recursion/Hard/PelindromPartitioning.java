package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class PelindromPartitioning {
    public static void main(String[] args) {
        String s = "aab"; 
//        List<List<String>> ans = partition(s);
//        System.out.println(ans);
    }
    public static String longestPalindrom(String s){
        int n = s.length(); 
        StringBuilder st = new StringBuilder(); 
        String ans = "";  
        generate(st, n, s, 0, ans); 
        return st.toString(); 
    }
    public static void generate(StringBuilder st, int n, String s, int index, String ans){
        if(index == n){
            if(st.length() > ans.length()){
                ans = st.toString(); 
            }
            return; 
        }
        for(int i = index; i < n; i++){

        }
    }
    /*
    public static List<List<String>> partition(String s){
        List<List<String>> ans = new ArrayList<>(); 
        List<String> path = new ArrayList<>(); 
        int index = 0; 
        int n = s.length(); 
        generate(index, s, path, ans,n); 
        return ans; 
    }
    private static void generate(int index, String s, List<String> path, List<List<String>> ans,int n){
        if(index == n){
            ans.add(new ArrayList<>(path)); 
            return; 
        }
        for(int i = index; i < n; i++){
            if(isPalindrom(s, index, i)){
                path.add(s.substring(index, i+1)); 
                generate(i+1, s, path, ans, n);
                path.remove(path.size()-1); 
            }
        }
    }
    private static boolean isPalindrom(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false; 
            }
        }
        return true; 
    }
     */
    
}
