package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubSequenceForThreeString {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "efgh";
        String s3 = "ijkl";
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        int LCSof3Memo = LCSof3Memo(s1, s2, s3, n1, n2, n3);
        System.out.println(LCSof3Memo);
    }

    public static int LCSof3Memo(String A, String B, String C, int n1, int n2, int n3) {
        int index1 = A.length() - 1;
        int index2 = B.length() - 1;
        int index3 = C.length() - 1;
        int[][][] dp = new int[n1][n2][n3];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helperMemo(index1, index2, index3, A, B, C, dp);
    }
    private static int helperMemo(int index1, int index2, int index3, String A, String B, String C, int[][][] dp){
        if(index1 < 0 || index2 < 0 || index3 < 0){
            return 0;
        }
        if(dp[index1][index2][index3] != -1){
            return dp[index1][index2][index3];
        }
        if(A.charAt(index1) == B.charAt(index2) && B.charAt(index2) == C.charAt(index3)){
            dp[index1][index2][index3] = 1 + helperMemo(index1-1, index2-1, index3-1, A, B, C, dp);
            return dp[index1][index2][index3];
        }
        dp[index1][index2][index3] = Math.max(Math.max(helperMemo(index1-1, index2, index3, A, B, C, dp), helperMemo(index1, index2-1,index3,A,B,C, dp)), helperMemo(index1,index2,index3-1,A,B,C,dp));
        return dp[index1][index2][index3];
    }
}
