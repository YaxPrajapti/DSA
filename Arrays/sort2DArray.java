package Arrays;

import java.util.Arrays;

public class sort2DArray {
    public static void main(String[] args) {
        int[][] arr = { { 1, 3 }, { 2, 4 }, { 6, 8 }, { 9, 10 } }; 
        Arrays.sort(arr); 
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }   
    }
}
