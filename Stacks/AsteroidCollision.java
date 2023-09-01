package Stacks;

import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] nums = {-2,-1,1,2}; 
        int[] collisons = collision(nums); 
        for(int i : collisons){
            System.out.print(i + " ");
        }
    }
    public static int[] collision(int[] nums){
        Stack<Integer> stack = new Stack<>(); 
        for(int i = 0; i < nums.length; i++){
            if(stack.isEmpty() || nums[i] > 0){
                stack.push(nums[i]); 
            }else{
                while(true){
                    int peek = stack.peek(); 
                    if(peek < 0){
                        stack.push(nums[i]); 
                        break; 
                    }else if(peek == -nums[i]){
                        stack.pop(); 
                        break; 
                    } else if(peek > -nums[i]){
                        break; 
                    } else{
                        stack.pop(); 
                        if(stack.isEmpty()){
                            stack.push(nums[i]);
                            break; 
                        }
                    }
                }
            }
        }
        int[] ans = new int[stack.size()]; 
        for(int i = stack.size()-1; i >=0 ; i--){
            ans[i] = stack.pop(); 
        }
        return ans; 
    }
}
