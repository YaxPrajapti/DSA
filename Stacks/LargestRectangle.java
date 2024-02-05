package Stacks;

import java.util.Stack;

public class LargestRectangle {
    public static void main(String[] args) {
        int[] arr = {2,4}; 
        int largestRectangleArea = largestRectangleArea(arr); 
        System.out.println(largestRectangleArea);
    }
    public static int largestRectangleArea(int[] arr){
        int n = arr.length; 
        int[] nextSmallerElement = nextSmallerElement(arr); 
        int[] prevSmallerElement = prevSmallerElement(arr); 
        int area = Integer.MIN_VALUE; 
        for(int i = 0; i < arr.length; i++){
            int length = arr[i]; 
            if(nextSmallerElement[i] == -1){
                nextSmallerElement[i] = n; 
            }
            int breadth = nextSmallerElement[i] - prevSmallerElement[i] - 1; 
            int newArea = length * breadth; 
            area = Math.max(newArea, area); 
        }
        return area; 
    }
    private static int[] nextSmallerElement(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>(); 
        stack.push(-1); 
        for(int i = arr.length-1; i >= 0; i--){
            int curr = arr[i]; 
            while(stack.peek() != -1 && arr[stack.peek()] >= curr){
                stack.pop(); 
            }
            ans[i] = stack.peek(); 
            stack.push(i); 
        }
        return ans; 
    }
    private static int[] prevSmallerElement(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>(); 
        stack.push(-1); 
        for(int i = 0; i < arr.length; i++){
            int curr = arr[i]; 
            while(stack.peek() != -1 && arr[stack.peek()] >= curr){
                stack.pop(); 
            }
            ans[i] = stack.peek(); 
            stack.push(i); 
        }
        return ans; 
    }
}
