package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArithmeticSlice2 {
    public static void main(String[] args) {
        int[] nums = {7,7,7,7,7}; 
        int numberOfArithmeticSlices = numberOfArithmeticSlices(nums);
        System.out.println(numberOfArithmeticSlices);
    }
    public static int numberOfArithmeticSlices(int[] arr){
        int n = arr.length; 
        HashMap<Integer, Integer>[] maps = new HashMap[n]; 
        for(int i = 0; i < n; i++){
            maps[i] = new HashMap<>(); 
        }
        int total_subsequence = 0; 
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                long diff = (long)arr[i] - (long)arr[j]; 
                int diffInt = (int)diff; 
                maps[i].put(diffInt, maps[i].getOrDefault(diffInt, 0)+1); 
                if(maps[j].containsKey(diffInt)){
                    maps[i].put(diffInt, maps[j].get(diffInt)+maps[i].get(diffInt)); 
                    total_subsequence += maps[j].get(diffInt); 
                }   
            }
        }
        return total_subsequence; 
    }
    
}
