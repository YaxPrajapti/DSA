package Recursion.SubSequences;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        List<String> ans = generateParenthesis(n);
        System.out.println(ans);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        int open = 0;
        int close = 0;
        generate(ans, open, close, new StringBuilder(), n);
        return ans;
    }

    private static void generate(List<String> ans, int open, int close, StringBuilder st, int n) {
        if (open == n && close == n && open == close) {
            ans.add(st.toString());
            return;
        }
        if (open < n) {
            st.append('(');
            generate(ans, open + 1, close, st, n);
            if (st.charAt(st.length() - 1) == '(') {
                st.deleteCharAt(st.length() - 1);

            }
        }
        if (close < open) {
            st.append(')');
            generate(ans, open, close + 1, st, n);
            st.deleteCharAt(st.length() - 1);
        }
    }
}
