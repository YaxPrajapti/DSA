package Stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement2 {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        int[] ans = nextgreaterelement(arr); 
        for(int i : ans){
            System.out.print(i + " ");
        }
    }
    public static int[] nextgreaterelement(int[] arr){
        Stack<Integer> stack = new Stack<>();
        for(int i = arr.length-1; i >=0; i--){
            stack.push(arr[i]);
        }
        int[] ans = new int[arr.length];
        for(int i = arr.length-1; i >= 0; i--){
            while (!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return ans;
    }
}
