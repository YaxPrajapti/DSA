package Stacks;

import java.util.Stack;

public class FindCelebrity {
    public static void main(String[] args) {
        int n = 3;
        int[][] M = { { 0, 1, 0 },
                { 0, 0, 0 },
                { 0, 1, 0 } };
        int index = celebrity(M, n);
        System.out.println(index);
    }

    public static int celebrity(int M[][], int n) {
        //add all person in stack 
        Stack<Integer> stack = new Stack<>(); 
        for(int i = 0; i < n; i++){
            stack.push(i); 
        }

        //discard two elements until stack.size is not equal to 1. 
        while(stack.size() != 1){
            int a = stack.pop(); 
            int b = stack.pop(); 
            if(knows(a,b,M)){
                stack.push(b);
            }else{
                stack.push(a); 
            }
        }

        //check for row and col for celebrity condition.
        int candidate = stack.peek(); 
        boolean rowCheck = false; 
        int zeroCount = 0; 
        for(int i = 0; i < n; i++){
            if(M[candidate][i] == 0){
                zeroCount++; 
            }
        }
        if(zeroCount == n){
            rowCheck = true; 
        }
        boolean colCheck = false; 
        int oneCount = 0; 
        for(int i = 0; i < n; i++){
            if(M[i][candidate] == 1){
                oneCount++; 
            }
        }
        if(oneCount == n-1){
            colCheck = true; 
        }

        if(rowCheck == true && colCheck == true){
            return candidate; 
        }
        return -1; 
    }
    private static boolean knows(int a, int b, int[][] M){
        return M[a][b] == 1; 
    }
}
