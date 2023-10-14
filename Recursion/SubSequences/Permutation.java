package Recursion.SubSequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.*; 

import javax.swing.text.html.HTMLDocument.Iterator;

public class Permutation {
    public static void main(String[] args) {
        int[] arr = {3,3,0,3}; 
        List<List<Integer>> ans = permutations(arr); 
        System.out.println(ans);
    }
    public static List<List<Integer>> permutations(int[] arr){
        int index = 0; 
        List<List<Integer>> ans = new ArrayList<>(); 
        permute(arr, index, ans); 
        return ans; 
    }
    public static void permute(int[] arr, int index, List<List<Integer>> ans){
        if(index == arr.length){
            List<Integer> ds = new ArrayList<>(); 
            for(int i : arr){
                ds.add(i); 
            }
            ans.add(new ArrayList<>(ds)); 
            return; 
        }
        for(int i = index; i < arr.length; i++){
            swap(arr, index, i); 
            permute(arr, index+1, ans);
            swap(arr, index, i); 
            
        }
    }
    private static void swap(int[] arr, int index, int i){
        int temp = arr[index]; 
        arr[index] = arr[i]; 
        arr[i] = temp; 
    }
}
