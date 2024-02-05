package Arrays;

public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] arr = {{1,1,1},
                        {1,0,1},
                        {1,1,1}}; 
        setZeros(arr);
        for(int i = 0; i <arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void setZeros(int[][] arr){
        int[] rows = new int[arr.length]; 
        int[] cols = new int[arr[0].length]; 
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 0){
                    rows[i] = 1; 
                    cols[j] = 1; 
                }
            }
        }
        //make rows 0; 
        for(int i = 0; i < rows.length; i++){
            if(rows[i] == 1){
                makerowszero(i, arr); 
            }
        }
        for(int j = 0; j < cols.length; j++){
            if(cols[j] == 1){
                makecolszero(j, arr); 
            }
        }
    }
    private static void makerowszero(int row, int[][] arr){
        for(int j = 0; j < arr[0].length; j++){
            arr[row][j] = 0; 
        }
    }
    private static void makecolszero(int col, int[][] arr){
        for(int i = 0; i < arr.length; i++){
            arr[i][col] = 0; 
        }
    }
}
