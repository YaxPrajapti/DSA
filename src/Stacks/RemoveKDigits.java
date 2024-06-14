package Stacks;

import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        String s = "725083"; 
        int k = 5; 
        String ans = removeKdigits(s, k); 
        System.out.println(ans); 
    }
    public static String removeKdigits(String str, int k){
        if(k > str.length()){
            return "0"; 
        }
        StringBuilder sb = new StringBuilder(); 
        Stack<Character> stack = new Stack<>(); 
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i); 
            if(stack.isEmpty()){
                stack.push(ch);
            }else{
                while (!stack.isEmpty() && stack.peek() > ch && k != 0) {
                    stack.pop(); 
                    k--; 
                }
                stack.push(ch); 
            }
        }
        while (k > 0) {
            stack.pop(); 
            k--; 
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop()); 
        }
        if(sb.length() == 0){
            return "0"; 
        }
        int i = sb.length()-1; 
        while (sb.charAt(i) == '0' && sb.length() > 1) {
            sb.deleteCharAt(i);
            i--; 
        }
        return sb.reverse().toString(); 
    }
}
