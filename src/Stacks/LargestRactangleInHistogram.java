package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class LargestRactangleInHistogram {
    public static void main(String[] args) {
        int[] height = {2,1,5,6,2,3};
        int largetstArea = largestRectangleAreaSinglePass(height);
        System.out.println("largetstArea = " + largetstArea);
    }
    public static int largestRectangleAreaSinglePass(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        int n = heights.length;
        for(int i = 0; i <= n; i++){
            while (!stack.isEmpty() && (i == n || heights[stack.peek()] >= heights[i])){
                int h = heights[stack.peek()];
                stack.pop();
                int width;
                if(stack.isEmpty()){
                    width = i;
                }
                else{
                    width = i - stack.peek() - 1;
                }
                maxArea = Math.max(maxArea, h*width);
            }
            stack.push(i);
        }
        return maxArea;
    }
    public static int largestRectangleArea(int[] heights) {
        int[] nextSmaller = getNextSmaller(heights);
//        int[] prevSmaller = getPrevSmaller(heights);
        int ans = 0;
        System.out.println("nextSmaller"+ Arrays.toString(nextSmaller));
//        System.out.println("prevSmaller"+ Arrays.toString(prevSmaller));
        for(int i = 0; i < heights.length; i++){
            int right = nextSmaller[i] - i;
//            int left = i - prevSmaller[i];
            int area = (right)*heights[i];
            ans = Math.max(ans, area);
        }
        return ans;
    }
    private static int[] getNextSmaller(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[heights.length];
        for(int i = heights.length-1; i >= 0; i--){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = heights.length;
            }
            else{
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }
    private static int[] getPrevSmaller(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[heights.length];
        for(int i = 0; i < heights.length; i++){
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]){
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
