import java.util.Stack;

public class MaximalRactangle {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 0, 1, 0, 0 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 0, 0, 1, 0 } };
        int area = maximalRectangle(matrix); 
        System.out.println(area); 
    }

    public static int maximalRectangle(int[][] matrix) {
        int[] height = new int[matrix[0].length];
        int maxi = 0; 
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] == 1) {
                    height[i]++;
                } else {
                    height[i] = 0;
                }
            }
            maxi = Math.max(maxi, compute(height)); 
        }
        return maxi; 
    }
    
    public static int compute(int[] height){
        int n = height.length; 
        int[] prevSmallerArray = prevSmaller(height);
        int[] nextSmallerArray = nextSmaller(height);
        int maxi = height[0];
        for (int i = 0; i < n; i++) {
            System.out.print(nextSmallerArray[i] + " ");
            System.out.print(prevSmallerArray[i] + " ");
            System.out.print(height[i] + " ");
            int width = nextSmallerArray[i] - prevSmallerArray[i] - 1;
            int area = width * height[i];
            System.out.print(area);
            System.out.println();
            maxi = Math.max(maxi, area);
        }
        return maxi;
    }

    public static int[] prevSmaller(int[] height) {
        int n = height.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && height[stack.peek()] >= height[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }
            stack.add(i);
        }
        return ans;
    }

    public static int[] nextSmaller(int[] height) {
        int n = height.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && height[stack.peek()] >= height[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = n;
            } else {
                ans[i] = stack.peek();
            }
            stack.add(i);
        }
        return ans;
    }
}
