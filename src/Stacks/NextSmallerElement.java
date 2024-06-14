package Stacks;

import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3}; 
        int[] ans = new int[arr.length]; 
        nextSmallerElement(arr, ans);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
    public static void nextSmallerElement(int[] arr, int[] ans){
        Stack<Integer> stack = new Stack<>(); 
        stack.push(-1); 
        for(int i = arr.length-1; i >= 0; i--){
            int curr = arr[i]; 
            while(stack.peek() > curr){
                stack.pop(); 
            }
            ans[i] = stack.peek(); 
            stack.push(curr); 
        }
        return; 
    }
    public static void prevSmallerElement(int[] arr, int[] ans){
        Stack<Integer> stack = new Stack<>(); 
        stack.push(-1); 
        for(int i = 0; i < arr.length; i++){
            int curr = arr[i]; 
            while(stack.peek() > curr){
                stack.pop(); 
            }
            ans[i] = stack.peek(); 
            stack.push(curr);
        }
        return; 
    }
}
