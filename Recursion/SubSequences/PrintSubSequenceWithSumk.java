package Recursion.SubSequences;

import java.util.ArrayList;
import java.util.List;

public class PrintSubSequenceWithSumk {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 2 };
        int k = 3;
        List<List<Integer>> ans = findSubSequence(arr, k);
        System.out.println(ans);
    }

    public static List<List<Integer>> findSubSequence(int[] arr, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int index = 0;
        int sum = 0;
        generate(arr, k, ans, index, sum, new ArrayList<>());
        return ans;
    }

    private static void generate(int[] arr, int k, List<List<Integer>> ans, int index, int sum, List<Integer> temp) {
        if (index == arr.length) {
            if(sum == k){
                ans.add(new ArrayList<>(temp));
                return; 
            }
            return;
        }
        sum = sum + arr[index];
        temp.add(arr[index]);
        generate(arr, k, ans, index + 1, sum, temp);
        sum = sum - arr[index];
        temp.remove(temp.size() - 1);
        generate(arr, k, ans, index + 1, sum, temp);
    }
}
