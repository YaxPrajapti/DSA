package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class DailyTempretures {
    public static void main(String[] args) {
        int[]  temperatures= {30,60,90};
        int[] ans = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] dailyTemperatures(int[] temperatures){
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>(); //it will store the index of next greater element.
        for(int i = temperatures.length-1; i >= 0; i--){
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperature){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = 0;
            }else{
                ans[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return ans;
    }
}
