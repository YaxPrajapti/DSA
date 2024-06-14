package Arrays;

import java.util.HashMap;

public class SubArraysWithSumK {
    public static void main(String[] args) {
        int[] arr = {-1,1,0}; 
        int k = 0; 
        int findcountofsubarrays = findCountOfSubArrays(arr, k); 
        System.out.println(findcountofsubarrays);
    }
    public static int findCountOfSubArrays(int[] arr, int k){
        int count = 0; 
        HashMap<Integer, Integer> map = new HashMap<>(); 
        int presum = 0; 
        map.put(0, 1); 
        for(int i = 0; i < arr.length; i++){
            presum += arr[i]; 
            int diff =  presum - k; 
            count+=map.getOrDefault(diff, 0); 
            if(map.containsKey(presum)){
                map.replace(presum, map.get(presum)+1); 
            }else{
                map.put(presum, 1); 
            }
        }
        return count; 
    }
}
