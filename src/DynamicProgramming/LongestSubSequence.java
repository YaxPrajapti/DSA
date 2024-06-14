package DynamicProgramming;

import java.util.Arrays;

public class LongestSubSequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
//        int len =longestCommonSubsequenceMemo(text1, text2);
        int len = longestCommonSubsequenceTabulation(text1, text2);
        System.out.println("len = " + len);
    }
    public static int longestCommonSubsequenceTabulation(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i < n; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j < m; j++){
            dp[0][j] = 0;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public static int longestCommonSubsequenceMemo(String text1, String text2){
        int index1 = text1.length()-1;
        int index2 = text2.length()-1;
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return helperMemo(index1, index2, text1, text2, dp);
    }
    private static int helperMemo(int index1, int index2, String text1, String text2, int[][] dp){
        if(index1 < 0 || index2 < 0){
            return 0;
        }
        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }
        if(text1.charAt(index1) == text2.charAt(index2)){
            dp[index1][index2] = 1 + helperMemo(index1-1, index2-1, text1, text2, dp);
            return dp[index1][index2];
        }
        dp[index1][index2] =  Math.max(helperMemo(index1-1,index2,text1,text2,dp),helperMemo(index1,index2-1,text1,text2,dp));
        return dp[index1][index2];
    }
}
