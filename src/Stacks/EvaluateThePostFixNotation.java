package Stacks;

import java.util.Stack;

public class EvaluateThePostFixNotation {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int ans = evaluate(tokens);
        System.out.println("ans = " + ans);
    }
    public static int evaluate(String[] postfix){
        if(postfix.length == 1){
            return Integer.parseInt(postfix[0]);
        }
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < postfix.length; i++){
            String ch = postfix[i];
            if(ch.equals("+")){
                int second = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());
                int result = first+second;
                stack.push(String.valueOf(result));
            }else if(ch.equals("-")){
                int second = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());
                int result = first-second;
                stack.push(String.valueOf(result));
            }else if(ch.equals("*")){
                int second = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());
                int result = first*second;
                stack.push(String.valueOf(result));
            }
            else if(ch.equals("/")){
                int second = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());
                int result = first/second;
                stack.push(String.valueOf(result));
            }else{
                stack.push(ch); 
            }
        }
        return Integer.parseInt(stack.peek()); 
    }
}
