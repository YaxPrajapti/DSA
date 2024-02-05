package Stacks;

import java.util.Stack;

public class RemoveKDigits2 {
    public static void main(String[] args) {
        String num = "725083";
        int k = 5;
        String ans = removeKdigits(num, k);
        System.out.println("ans = " + ans);
    }
    public static String removeKdigits(String num, int k){
        /*
        we will use stack data structure to keep track of the smallest characters will there be in string.
        we will insert elements in the string and if stack.peek is greater than the curr element, we will pop that out of the stack
        and insert current element. And will decrease the k by one.
        thats how we will maintain smaller string.
        After that, we will pop every element and append it to the string and reverse the string.
        If there are leading zeros in the string then will remove.
        edge case:
            if we have traversed the whole string and k > 0 then we still have chance to remove the elements from the string(stack)
            we will remove elements from the stack until k != 0;
        that's how the problem will be solved.
        */
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(Character ch : num.toCharArray()){
            if(stack.isEmpty()){
                stack.push(ch);
            }else{
                while (!stack.isEmpty() && stack.peek() > ch && k != 0){
                    stack.pop();
                    k--;
                }
                stack.push(ch);
            }
        }
        while(k != 0){
            stack.pop();
            k--;
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        int i = 0;
        while (i < sb.length()) {
            if (sb.charAt(i) == '0') {
                sb.deleteCharAt(i);
            } else {
                break;
            }
        }
        return (sb.isEmpty()) ? "0" : sb.toString();
    }
}
