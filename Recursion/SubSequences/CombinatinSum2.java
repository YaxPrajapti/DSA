package Recursion.SubSequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Arrays.sort2DArray;

public class CombinatinSum2 {
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};   
        int target = 8; 
        List<List<Integer>> ans = combinationSum2(arr, target); 
        System.out.println(ans);
    }
    /* optimal recursin approach */
    public static List<List<Integer>> combinationSum2(int[] arr, int target){
        List<List<Integer>> ans = new ArrayList<>(); 
        Arrays.sort(arr); 
        generate(arr,target, 0, ans, new ArrayList<>()); 
        return ans;  
    }
    private static void generate(int[] arr, int target, int index, List<List<Integer>> ans, List<Integer> ds){
        if(target == 0){
            ans.add(new ArrayList<>(ds)); 
            return; 
        }
        for(int i = index; i < arr.length; i++){
            if(i > index && arr[i] == arr[i-1]){
                continue; 
            }
            if(arr[i] > target){
                break; 
            }
            ds.add(arr[i]); 
            generate(arr, target-arr[i], i+1, ans, ds);
            ds.remove(ds.size()-1); 
        }
        }
    }

    /* Brute force */
    /* 
    public static List<List<Integer>> combinationSum2(int[] arr, int target){
        Arrays.sort(arr); 
        Set<List<Integer>> set = new HashSet<>(); 
        int index = 0; 
        generate(arr, target, index, set, new ArrayList<>()); 
        List<List<Integer>> ans = new ArrayList<>(); 
        ans.addAll(set); 
        return ans; 
    }
    private static void generate(int[] arr, int target, int index, Set<List<Integer>> set, List<Integer> temp){
        if(target == 0){
            set.add(new ArrayList<>(temp));
            return; 
        }
        if(index == arr.length){
            if(target == 0){
                set.add(new ArrayList<>(temp)); 
            }
            return; 
        }
        if(arr[index] <= target){
            temp.add(arr[index]); 
            generate(arr, target-arr[index], index+1, set, temp);
            temp.remove(temp.size()-1); 
        }
        generate(arr, target, index+1, set, temp);
    }*/
    

