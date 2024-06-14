package Stacks;

import java.util.Stack;

public class MaximalRactangle {
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int area = maximalRectangle(matrix);
        System.out.println(area);
    }
    private static int largestRectangleAreaSinglePass(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        int n = heights.length;
        for(int i = 0; i <= n; i++) {
            while(!stack.isEmpty() && (i == n || heights[stack.peek()] >= heights[i])){
                int h = heights[stack.peek()];
                stack.pop();
                int width;
                if(stack.isEmpty()){
                    width = i;
                }else{
                    width = i - stack.peek() - 1;
                }
                maxArea = Math.max(maxArea, h*width);
            }
            stack.push(i);
        }
        return maxArea;

    }
    public static int maximalRectangle(char[][] matrix) {
        int[] height = new int[matrix[0].length];
        int maxArea = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == '1'){
                    height[j]++;
                }else{
                    height[j] = 0;
                }
            }
            int area = largestRectangleAreaSinglePass(height);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
