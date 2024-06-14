package Recursion.SubSequences;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubSeqences {
    public static void main(String[] args) {
        int[] arr = {3,1,2}; 
        List<List<Integer>> ans = new ArrayList<>(); 
        List<Integer> temp = new ArrayList<>(); 
        helper(arr, 0, ans ,temp);
        System.out.println(ans);
    }
    public static void helper(int[] arr, int index, List<List<Integer>> ans, List<Integer> temp){
        if(index == arr.length){
            ans.add(new ArrayList<>(temp)); 
            return; 
        }
        temp.add(arr[index]); 
        helper(arr, index+1, ans, temp);
        temp.remove(temp.size()-1);
        helper(arr, index+1, ans, temp);
    }
}
