package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubstrnig {
    public static void main(String[] args) {
        String s = "cbbd"; 
        String longestPalindrom = longestPalindrom(s); 
        System.out.println(longestPalindrom);
    }

    public static String longestPalindrom(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        int index = 0;
        int n = s.length();
        generate(index, s, path, ans, n);
        String temp = ans.get(0).get(0); 
        for(int i = 0; i < ans.size(); i++){
            for(int j = 0; j < ans.get(i).size(); j++){
                if(ans.get(i).get(j).length() > temp.length()){
                    temp = ans.get(i).get(j); 
                }
            }
        }
        return temp; 
    }

    private static void generate(int index, String s, List<String> path, List<List<String>> ans, int n) {
        if (index == n) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < n; i++) {
            if (isPalindrom(s, index, i)) {
                path.add(s.substring(index, i + 1));
                generate(i + 1, s, path, ans, n);
                // path.remove(path.size() - 1);
            }
        }
    }

    private static boolean isPalindrom(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
