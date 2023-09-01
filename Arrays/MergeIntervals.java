package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        // int[][] intervals = {{1,3},{2,4},{6,8},{9,10}};
        int[][] intervals =  {{6,8},{1,9},{2,4},{4,7}};
        List<List<Integer>> ans = merger(intervals); 
        System.out.println(ans);
    }

    public static List<List<Integer>> merger(int[][] intervals) {
        int n = intervals.length; 
        List<List<Integer>> arr = new ArrayList<>(); 
        // sort the array 
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        for(int index = 0; index < n; index++){
            // if the current interval does not lie in the last stored or merged interval. 
            if(arr.isEmpty() || intervals[index][0] > arr.get(arr.size()-1).get(1)){
                arr.add(Arrays.asList(intervals[index][0], intervals[index][1])); 
            }
            //there is an interval between last merged and current index index; 
            else if(intervals[index][0] < arr.get(arr.size()-1).get(1)){
                //starting element of interval; 
                if(intervals[index][0] < arr.get(arr.size()-1).get(0)){
                    arr.get(arr.size()-1).set(0, intervals[index][0]); 
                }
                if(intervals[index][1] > arr.get(arr.size()-1).get(1)){
                    arr.get(arr.size()-1).set(1, intervals[index][1]); 
                }
            }
        }
        return arr; 
    }
}
