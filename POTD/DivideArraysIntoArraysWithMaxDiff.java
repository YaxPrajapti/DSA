package POTD;

import java.util.Arrays;

public class DivideArraysIntoArraysWithMaxDiff {
    public static void main(String[] args) {
        int[] arr = {1,3,3,2,7,3};
        int k = 3;
        int[][] ans = divideArray(arr, k);
        for(int i = 0; i < ans.length; i++){
            System.out.println(Arrays.toString(ans[i]));
        }
    }
    public static int[][] divideArray(int[] arr, int k){
        Arrays.sort(arr);
        int[][] ans = new int[arr.length/3][3];
        int pointer = 0;
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < 3; j++){
                ans[i][j] = arr[pointer];
                pointer++;
            }
        }
        for(int[] row : ans){
            if(row[2] - row[1] > k){
                return new int[][]{};
            }
        }
        return ans;
    }
}
