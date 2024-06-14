package Strings;

public class MaxinumNestedDepthOfParanthesis {
    public static void main(String[] args) {
        String s = "(1)+((2))+(((3)))";
        int max = maxDepth(s);
        
        System.out.println(max);
    }
    public static int maxDepth(String s) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                count++;
            }else if(ch == ')'){
                count--;
            }else {
                continue;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
