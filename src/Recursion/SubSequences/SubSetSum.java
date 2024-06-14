package Recursion.SubSequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SubSetSum {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(); 
        arr.add(5); 
        arr.add(2);
        arr.add(1); 
        int N = arr.size(); 
        ArrayList<Integer> subsetSum = subsetSums(arr, N); 
        Collections.sort(subsetSum);
        System.out.println(subsetSum);                
    }
    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        int index = 0; 
        int sum = 0; 
        ArrayList<Integer> ans = new ArrayList<>(); 
        generate(arr, N, index, sum, ans); 
        return ans; 
    }
    private static void generate(ArrayList<Integer> arr, int N, int index, int sum, ArrayList<Integer> ans){
        if(index == N){
            ans.add(sum);
            return; 
        }
        sum += arr.get(index); 
        generate(arr, N, index+1, sum, ans);
        sum -= arr.get(index); 
        generate(arr, N, index+1, sum, ans);
    }
}
