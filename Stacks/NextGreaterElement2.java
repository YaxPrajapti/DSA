package Stacks;

import java.util.Stack;

public class NextGreaterElement2 {
    public static void main(String[] args) {
        int[] arr = {1,2,1}; 
        int[] ans = nextgreaterelement(arr); 
        for(int i : ans){
            System.out.print(i + " ");
        }
    }
    public static int[] nextgreaterelement(int[] arr){
        Stack<Integer> stack = new Stack<>(); 
        int[] ans = new int[arr.length]; 
        int n = arr.length; 
        for(int i = n-1; i >= 0; i--){
            stack.push(arr[i]); 
        }
        for(int i = n-1; i >= 0; i--){
            int curr = arr[i]; 
            while(!stack.isEmpty() && stack.peek() <= curr){
                stack.pop(); 
            }
            if(stack.isEmpty()){
                ans[i] = -1; 
            }else{
                ans[i] = stack.peek(); 
            }
            stack.push(curr); 
        }
        return ans; 
    }
}
