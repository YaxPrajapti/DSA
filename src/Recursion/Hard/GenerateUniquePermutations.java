package Recursion.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class GenerateUniquePermutations {
    public static void main(String[] args) {
        int[] arr = {1,2,1}; 
        int n = arr.length; 
        ArrayList<ArrayList<Integer>> list = uniquePerms(arr, n); 
        System.out.println(list);
    }
    public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr, int n){
        Set<ArrayList<Integer>> set = new HashSet<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(); 
        boolean[] freq = new boolean[n]; 
        Arrays.fill(freq, false);
        Arrays.sort(arr);
        helper(arr, n, set, new ArrayList<>(), freq, list); 
        Collections.sort(list, Comparator.comparing(temp -> temp.get(0))); 
        return list; 
    }
    private static void helper(int[] arr, int n, Set<ArrayList<Integer>> set, ArrayList<Integer> temp, boolean[] freq, ArrayList<ArrayList<Integer>> list){
        if(temp.size() == n){
            if(!set.contains(temp)){
                set.add(new ArrayList<>(temp)); 
                list.add(new ArrayList<>(temp)); 
            }
            return; 
        }
        for(int i = 0; i < n; i++){
            if(!freq[i]){
                freq[i] = true; 
                temp.add(arr[i]); 
                helper(arr, n, set, temp, freq, list);
                freq[i] = false; 
                temp.remove(temp.size() - 1); 
            }
        }
    }
}
