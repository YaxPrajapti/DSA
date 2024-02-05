package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxLengthOfConcatenatedString {
    public static void main(String[] args) {
        String[] strings = {"abcdefghijklmnopqrstuvwxyz"};
        List<String> arr = new ArrayList<>();
        for(String s: strings){
            arr.add(s);
        }
        int len = maxLength(arr);
        System.out.println("len = " + len);
    }
    public static int maxLength(List<String> arr){
        int[] len = {0};
        if(arr.size() == 0){
            return 0;
        }
        helper(len, arr, new StringBuilder(), 0);
        return len[0];
    }
    private static void helper(int[] len, List<String> arr, StringBuilder sb, int index){
        if(index == arr.size()){
            return;
        }
        String s = arr.get(index);
        //pick
        //we can pick only when all the chars are unique after concating
        if(check(s, sb)){
            sb.append(s.toCharArray());
            helper(len, arr, sb, index+1);
            len[0] = Math.max(len[0], sb.length());
            sb.delete(sb.length()-s.length(), sb.length());
        }
        //not pick
        helper(len, arr, sb, index+1);
        return;
    }
    private static Boolean check(String s, StringBuilder sb){
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                return false;
            }
            set.add(s.charAt(i));
        }
        for(int i = 0; i < sb.length(); i++){
            if(set.contains(sb.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
