package DynamicProgramming;

import java.util.Arrays;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        String s = "";
        int count =countSubstrings(s);
        System.out.println(count);
    }
    public static int countSubstrings(String s){
        int count = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
//        Arrays.fill(dp, false);
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                if(isPalindrom(s.substring(i, j+1), dp)) count++;
            }
        }
        return count;
    }

    public static boolean isPalindrom(String s, boolean[][] dp){
        int i = 0;
        int j = s.length()-1;
        if(dp[i][j]){
            return dp[i][j];
        }
        while (i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        dp[i][j] = true;
        return true;
    }
}
