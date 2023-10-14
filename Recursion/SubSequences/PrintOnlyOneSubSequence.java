package Recursion.SubSequences;

import java.util.ArrayList;
import java.util.List;

public class PrintOnlyOneSubSequence {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int k = 2; 
        List<List<Integer>> ans = printOnlyOneSubSequence(arr, k); 
        System.out.println(ans);
    }
    public static List<List<Integer>> printOnlyOneSubSequence(int[] arr, int k){
        int index = 0; 
        List<List<Integer>> ans = new ArrayList<>(); 
        List<Integer> temp = new ArrayList<>(); 
        int sum = 0; 
        generate(arr, k, index, ans, temp, sum);
        return ans; 
    }
    private static boolean generate(int[] arr, int k, int index, List<List<Integer>> ans, List<Integer> temp, int sum){
        if(index == arr.length){
            if(sum == k){
                ans.add(new ArrayList<>(temp));
                return true; 
            }
            return false; 
        }
        //case: Pick
        sum+=arr[index]; 
        temp.add(arr[index]); 
        if(generate(arr, k, index+1, ans, temp, sum)){
            return true; 
        } 
        sum-=arr[index]; 
        temp.remove(temp.size()-1); 
        if(generate(arr, k, index+1, ans, temp, sum)){
            return true; 
        }
        return false; 
    }

}
