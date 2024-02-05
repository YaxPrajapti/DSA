package Recursion.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GenerateAllPermutations {
    public static void main(String[] args) {
        int[] arr = {1,2,1}; 
        ArrayList<ArrayList<Integer>> list = permutations(arr); 
        System.out.println(list);
    }
    public static ArrayList<ArrayList<Integer>> permutations(int[] arr){
        // Arrays.sort(arr); // uncomment this if we want permutations in sorted order. 
        boolean[] freq = new boolean[arr.length]; 
        Arrays.fill(freq, false);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(); 
        int n = arr.length; 
        helper(arr, freq, list, new ArrayList<>(), n); 
        return list; 
    }
    private static void helper(int[] arr, boolean[] freq, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> temp, int n){
        if(temp.size() == n){
            list.add(new ArrayList<>(temp)); 
            return; 
        }
        for(int i = 0; i < n; i++){
            if(!freq[i]){
                freq[i] = true; 
                temp.add(arr[i]); 
                helper(arr, freq, list, temp, n);
                temp.remove(temp.size()-1); 
                freq[i] = false; 
            }
        }
    }
}
