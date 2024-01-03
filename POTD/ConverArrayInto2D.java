package POTD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConverArrayInto2D {
    public static void main(String[] args) {
        int[] nums = {1,3,4,1,2,3,1}; 
        List<List<Integer>> matrix = findMatrix(nums); 
        System.out.println(matrix);
    }
    public static List<List<Integer>> findMatrix(int[] nums){
        int[] visited = new int[nums.length]; 
        Arrays.fill(visited, 0);
        List<List<Integer>> ans = new ArrayList<>(); 
        boolean flag = true; 
        while (flag) {
            flag = false; 
            Set<Integer> set = new HashSet<>(); 
            for(int i = 0; i < nums.length; i++){
                if(!set.contains(nums[i]) && visited[i] == 0){
                    flag = true; 
                    visited[i] = 1; 
                    set.add(nums[i]); 
                }
            }
            if(set.size() > 0){
                ans.add(new ArrayList<>(set)); 
            }
        }
        return ans; 
    }

}
