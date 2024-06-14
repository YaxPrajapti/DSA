package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class asteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {-2,-1,1,-2};
        int[] ans = asteroidCollision(asteroids);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] asteroidCollision(int[] asteroids) {
       Stack<Integer> stack = new Stack<>();
       for (Integer a : asteroids){
           //if stack is empty or we encounter a positive direction asteroid
           if(stack.isEmpty() || a > 0){
               stack.push(a);
           }else{
               //if the stack top is nagetive
               if(stack.isEmpty()){
                   stack.push(a);
                   continue;
               }
               else if(!stack.isEmpty() && stack.peek() < 0){
                   stack.push(a);
                   continue;
               }
               else{
                   //now the stack peek positive.
                   //we need to remove asteroids which are smaller than the current asteroid
                   while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(stack.peek()) < Math.abs(a)){
                       stack.pop();
                   }
                   if(stack.isEmpty()){
                       stack.push(a);
                       continue;
                   }
                   if(stack.peek() < 0){
                       stack.push(a);
                       continue;
                   }else if (stack.peek() == Math.abs(a)) {
                       stack.pop();
                       continue;
                   }else {
                        continue;
                   }
               }

           }
       }
       int[] ans = new int[stack.size()];
       for (int i = ans.length-1; i >= 0; i--){
           ans[i] = stack.pop();
       }
       return ans;
    }
}
