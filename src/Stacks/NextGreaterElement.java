package Stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javax.print.attribute.HashAttributeSet;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr1 = {4,1,2}; 
        int[] arr2 = {1,3,4,2}; 
        int[] ans = nextGreaterElement(arr1, arr2); 
        for(int i : ans){
            System.out.print(i + " ");
        }
    }
    public static int[] nextGreaterElement(int[] arr1, int[] arr2){
        Map<Integer, Integer> map = new HashMap<>(); 
        int[] ans= new int[arr1.length]; 
        Stack<Integer> stack = new Stack<>(); 
        int n = arr2.length; 
        for(int i = n-1; i >= 0; i--){
            int curr = arr2[i]; 
            while(!stack.isEmpty() && stack.peek() < curr){
                stack.pop(); 
            } 
            if(stack.isEmpty()){
                map.put(curr, -1); 
            }else{
                map.put(curr, stack.peek()); 
            }
            stack.push(curr); 
        }
        for(int i = 0; i < arr1.length; i++){
            ans[i] = map.get(arr1[i]); 
        }
        return ans; 
    }
}
