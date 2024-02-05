package Stacks;

import java.util.Stack;

public class InfixToPostFix {
    public static void main(String[] args) {
        String infix = "h^m^q^(7-4)";
        String postfix = convertToPostfix(infix);
        System.out.println("postfix = " + postfix);
    }
    private static int prec(char c){
        if(c == '^')
        {
            return 3;
        }
        if(c == '/' || c == '*')
        {
            return 2;
        }
        if(c == '+' || c == '-')
        {
            return 1;
        }else
        {
            return -1;
        }
    }
    private static char associativity(char c){
        if(c == '^'){
            return 'R';
        }else {
            return 'L';
        }
    }
    private static String convertToPostfix(String infix){
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < infix.length(); i++){
            char c = infix.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                postfix.append(c);
            }
            else if(c == '('){
                stack.push(c);
            }
            else if(c == ')'){
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // remove the '(' from the stack too.
            }else {
                while (!stack.isEmpty() && (prec(c) < prec(stack.peek()) || (prec(c) == prec(stack.peek())))) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()){
            postfix.append(stack.pop());
        }
        return postfix.toString();

    }

}
