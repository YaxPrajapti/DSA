package Arrays;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;

public class NumberOfSubMatrixSumEqualToTarget {
    public static void main(String[] args) {
        int[][] matrix = {{0,0,0,1,1},{1,1,1,0,1},{1,1,1,1,0}, {0,0,0,1,0}, {0,0,0,1,1}};
        int target = 0;
        int count = numSubmatrixSumTarget(matrix, target);
        System.out.println("count = " + count);
    }

    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int[] summedRow = new int[m];
            for (int j = i; j < n; j++) { // this will manage the presum for every col. And handle the case where individual row should be added and presum should be done.
                for(int k = 0; k < m; k++){
                    summedRow[k] += matrix[j][k];
                }
                count += subArraySumRow(summedRow, target);
            }
        }
        return count;
    }
    private static int subArraySumRow(int[] summedRow, int target){
        int ans = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < summedRow.length; i++){
            sum += summedRow[i];
            if(map.containsKey(sum - target)){
                ans += map.get(sum-target);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);

        }
        return ans;
    }

}
