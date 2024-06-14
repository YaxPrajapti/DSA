package Stacks;

import java.util.Stack;

public class SumOfSubArrayMin {

    public static void main(String[] args) {
        int[] sum = {71,55,82,55};
        int ans = sumSubarrayMins(sum);
        System.out.println("ans = " + ans);
    }
    public static  int sumSubarrayMins(int[] arr){
        int[] nextSmallerElement = getNextSmaller(arr);
        int[] prevSmallerElement = getPrevSmaller(arr);
        long sum = 0;
        for (int i = 0; i < arr.length; i++){
            long ls = i - nextSmallerElement[i];
            long rs = prevSmallerElement[i] - i;
            long count = ls*rs;
            long curr_sum = count * arr[i];
            sum = (long) ((sum + curr_sum) % (Math.pow(10,(9)) + 7));
        }
        return (int)sum;
    }
    public static int[] getNextSmaller(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i = arr.length-1; i >= 0; i--){
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = arr.length;
            }
            else{
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }
    public static int[] getPrevSmaller(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i =0; i < arr.length; i++){
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }
}
