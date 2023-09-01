package Arrays;

import java.util.ArrayList;

public class SprialMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},
                        {4,5,6},
                    {7,8,9}};
        ArrayList<Integer> list = spiralMatrix(arr); 
        System.out.println(list);
    }

    public static ArrayList<Integer> spiralMatrix(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int left = 0;
        int right = m - 1;
        int top = 0;
        int bottom = n - 1;
        ArrayList<Integer> ans = new ArrayList<>();
        while (top <= bottom && left <= right) {
            // left to right;
            for (int i = left; i <= right; i++) {
                ans.add(arr[top][i]);
            }
            top++;
            // top to bottom;
            for (int i = top; i <= bottom; i++) {
                ans.add(arr[i][right]);
            }
            right--;
            // right to left;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(arr[bottom][i]);
                }
                bottom--;
            }
            // bottom to top;
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(arr[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}
