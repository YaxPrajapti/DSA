package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        int count = trap(height);
        System.out.println(count);
    }
    public static int trap(int[] height){
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < height.length; i++){
            int curr_height = height[i];
            //if the current height is larger then the stack.peek then we have the right boundary for the peek element;
            //Now we will pop out the statck element until we get the left boudanry
            //left boundary is the element which is greater than the right boundary(current height)
            while (!stack.isEmpty() && height[stack.peek()] < curr_height){
                int base_index = stack.pop();
                //if the stack gets empty we do now have any left boudary.
                if(stack.isEmpty()){
                    break;
                }
                //now we will calculate the distance from the the base to right boudary.
                int distance = i-stack.peek()-1;
                //now calculate the min of the left and right boundary.
                //Then calculate the min water that can fit inside the gap
                int min_height = Math.min(height[stack.peek()], height[i]) - height[base_index];
                count += distance * min_height;
            }
            stack.push(i);
        }
        return count;
    }
    //optimal approach
    public static int trapUsingTwoPointers(int[] heights){
        int count = 0;
        int left = 0;
        int right = heights.length-1;
        int leftmax = 0;
        int rightmax = 0;
        while (left <= right){
            //this will make sure that there will be a right boundary.
            if(heights[left] <= heights[right]){
                if(heights[left] >= leftmax){
                    leftmax = heights[left];
                }else {
                    count += leftmax - heights[left];
                }
                left++;
            }else {
                if(heights[right] >= rightmax){
                    rightmax = heights[right];
                }else{
                    count += rightmax - heights[right];
                }
                right--;
            }
        }
        return count;
    }

}
