package Recursion.SubSequences;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public static void main(String[] args) {
        int k = 3; 
        int n = 9; 
        List<List<Integer>> combinationSum3 = combinationSum3(k, n); 
        System.out.println(combinationSum3);
    }
    public static List<List<Integer>> combinationSum3(int k, int target){
        int index = 0; 
        int[] arr = {1,2,3,4,5,6,7,8,9}; 
        List<List<Integer>> ans = new ArrayList<>(); 
        generate(arr, index, k, target, ans, new ArrayList<>());
        return ans; 
    } 
    private static void generate(int[] arr, int index, int k, int target, List<List<Integer>> ans, List<Integer> temp){
        if(target == 0 && temp.size() == k){
            ans.add(new ArrayList<>(temp));
            return; 
        }
        if(index == arr.length){
            if(target == 0 && temp.size() == k){
                ans.add(new ArrayList<>(temp));
            }
            return; 
        }
        if(arr[index] <= target){
            temp.add(arr[index]); 
            generate(arr, index+1, k, target-arr[index], ans, temp);
            temp.remove(temp.size()-1); 
        }
        generate(arr, index+1, k, target, ans, temp);
    }
}
