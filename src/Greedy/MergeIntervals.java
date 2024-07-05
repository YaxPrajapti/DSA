package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * MergeIntervals
 */
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1,5},{2,3}}; 
        int[][] merged = merge(intervals); 
        for(int[] merge : merged){
            System.out.print("[" + merge[0] + ", " +merge[1] + "]");
            System.out.println();
        }
    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>(); 
        list.add(intervals[0]); 
        int index = 1; 
        int n =intervals.length; 
        while (index < n) {
            int start = intervals[index][0]; 
            int end = intervals[index][1]; 
            int[] last = list.get(list.size()-1); 
            if(last[1] >= start){
                //merge
                last[0] = Math.min(last[0], start);
                last[1] = Math.max(last[1], end); 
                list.set(list.size()-1, last);  
            }else{
                list.add(intervals[index]); 
            }
            index++; 
        }
        return list.toArray(new int[list.size()][2]);
    }
}