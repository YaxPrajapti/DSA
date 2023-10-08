package BinarySearch;


public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}}; 
        int target = 69; 
        boolean isThere = searchMatrix(matrix, target); 
        System.out.println(isThere);
    }
    public static boolean searchMatrix(int[][] matrix, int target){
        int row = -1; 
        //find the appropriate row
        int low = 0; 
        int high = matrix.length-1; 
        while(low <= high){
            int mid = (int)(low + high)/2; 
            int firstElement = matrix[mid][0];
            int lastElement = matrix[mid][matrix[mid].length-1]; 
            if(target < firstElement){
                high = mid - 1; 
            }else if(target > lastElement){
                low = mid + 1; 
            }else{
                row = mid; 
                break; 
            }
        }
        return (row > -1) ? searchInRow(matrix[row], target) : false; 
    }
    private static boolean searchInRow(int[] row, int target){
        int low = 0; 
        int high = row.length-1; 
        while(low <= high){
            int mid = (int)(low+high)/2; 
            if(row[mid] == target){
                return true; 
            }else if(target < row[mid]){
                high = mid - 1; 
            }else if(target > row[mid]){
                low = mid + 1; 
            }
        }
        return false; 
    }
}
