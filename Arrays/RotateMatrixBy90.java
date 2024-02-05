package Arrays;

public class RotateMatrixBy90 {
    public static void main(String[] args) {
        int[][] arr = {{5,1,9,11},
                       {2,4,8,10},
                       {13,3,6,7},
                       {15,14,12,16}}; 
        rotateMatrix(arr);  
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void rotateMatrix(int[][] arr){
        //We will have to do transpose of matrix 
        //and then we will reverse each row. 
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(i <= j){
                    int temp = arr[i][j]; 
                    arr[i][j] = arr[j][i]; 
                    arr[j][i] = temp; 
                }
            }
        }
        for(int i = 0; i < arr.length; i++){
            int start = 0; 
            int end = arr[i].length-1; 
            while(start < end){
                int temp = arr[i][start]; 
                arr[i][start] = arr[i][end]; 
                arr[i][end] = temp; 
                start++; 
                end--; 
            }
        }
    }
}
