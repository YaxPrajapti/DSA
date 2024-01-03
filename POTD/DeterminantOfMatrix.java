package POTD;

public class DeterminantOfMatrix {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 0, 2, -1 },
                { 3, 0, 0, 5 },
                { 2, 1, 4, -3 },
                { 1, 0, 5, 0 } };
        int n = matrix.length; 
        int determinant = determinantOfMatrix(matrix, n); 
        System.out.println(determinant);
    }

    public static int determinantOfMatrix(int[][] matrix, int n) {
        int[][] temp;
        int result = 0;
        if (matrix.length == 1) {
            result = matrix[0][0];
            return result;
        }
        if (matrix.length == 2) {
            result = ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));
            return result;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            temp = new int[matrix.length - 1][matrix.length - 1];
            for (int j = 1; j < matrix.length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    if (k < i) {
                        temp[j - 1][k] = matrix[j][k];
                    } else if (k > i) {
                        temp[j - 1][k - 1] = matrix[j][k];
                    }
                }
            }
            result += Math.pow(-1, i) * matrix[0][i] * determinantOfMatrix(temp, temp.length);

        }
        return result;
    }
}
