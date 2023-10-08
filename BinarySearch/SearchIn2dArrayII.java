package BinarySearch;

import Arrays.sort2DArray;

public class SearchIn2dArrayII {
    public static void main(String[] args) {
        // int[][] matrix = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}}; 
        int[][] matrix = {{5},{6}}; 
        int target = 5; 
        boolean ans = searchInMatrix(matrix, target); 
        System.out.println(ans);   
    }
    public static boolean searchInMatrix(int[][] matrix, int target){
        int row = -1; 
        int col = -1; 
        int n = matrix.length; 
        int m = matrix[0].length; 
        if(n == 1){
            return rowBS(matrix, target, 0, 0); 
        }
        if(m == 1){
            return colBS(matrix, target, 0, 0);
        }
        int i = 0; 
        int j = 0; 
        while(i < n && j < m){
            if(matrix[i][j] == target){
                return true; 
            }else if(matrix[i][j] < target){
                i++; 
                j++; 
            }else{
                row = i-1; 
                col = j-1; 
                return (row >= 0 && col >= 0) ? colBS(matrix, target, row, col) || rowBS(matrix, target, row, col) : false; 
            }
        }
        return false; 
    }
    private static boolean colBS(int[][] matrix, int target, int row, int col){
        int low = 0; 
        int high = matrix.length-1; 
        while(low <= high){
            int mid = (int)(low+high)/2; 
            if(matrix[mid][col] == target){
                return true; 
            }else if(target < matrix[mid][col]){
                high = mid - 1; 
            }else if(target > matrix[mid][col]){
                low = mid + 1; 
            }
        }
        return false; 
    }
    private static boolean rowBS(int[][] matrix, int target, int row, int col){
        int low = 0; 
        int high = matrix[row].length-1; 
        while(low <= high){
            int mid = (int)(low + high)/2; 
            if(matrix[row][mid] == target){
                return true; 
            }else if(target<matrix[row][mid]){
                high = mid - 1; 
            }else if(target > matrix[row][mid]){
                low = mid + 1; 
            }
        }
        return false; 
    }
}
