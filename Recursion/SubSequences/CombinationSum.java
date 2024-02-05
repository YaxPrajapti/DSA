package Recursion.SubSequences;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2,3,6,7}; 
        int target = 7; 
        List<List<Integer>> ans = combinationSum(arr, target); 
        System.out.println(ans);
    }
    public static List<List<Integer>> combinationSum(int[] arr, int target){
        int index = 0; 
        List<List<Integer>> ans = new ArrayList<>(); 
        List<Integer> temp = new ArrayList<>(); 
        int sum = 0; 
        combinations(arr, target, ans, temp, sum, index); 
        return ans; 
    }
    public static void combinations(int[] arr, int target, List<List<Integer>> ans, List<Integer> temp, int sum, int index){
        //base case 
        if(index == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(temp)); 
            }
            return; 
        }
        if(arr[index] <= target){
            temp.add(arr[index]); 
            combinations(arr, target-arr[index], ans, temp, sum, index);
            temp.remove(temp.size()-1); 
        }
        //case not pick 
        combinations(arr, target, ans, temp, sum, index+1);
    }
}
