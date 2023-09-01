package Arrays;

import java.util.HashMap;
import java.util.Map;

public class MergeIntervals {
    public static void main(String[] args) {
        // int[][] intervals = {{1,3},{2,4},{6,8},{9,10}};
        int[][] intervals = { { 1, 3 }, { 2, 4 }, { 6, 8 }, { 9, 10 } };
        int[][] merge = merger(intervals);
        for (int i = 0; i < merge.length; i++) {
            for (int j = 0; j < merge[i].length; j++) {
                System.out.print(merge[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] merger(int[][] intervals) {
        
    }
}
