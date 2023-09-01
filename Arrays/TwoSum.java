package Arrays; 
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {3,2,4}; 
        int target = 6; 
        int n = arr.length; 
        int[] pair = twosum(arr, n, target); 
        for(int i : pair){
            System.out.print(i + " ");
        }
    }
    public static int[] twosum(int[] arr, int n, int target){
        // HashMap<Integer, Integer> map = new HashMap<>(); 
        // int[] result = new int[2];
        // for(int i = 0; i < n; i++){
        //     int left = target - arr[i]; 
        //     if(!map.isEmpty() && map.containsKey(arr[i])){
        //         result[0] = i;
        //         result[1] = map.get(arr[i]); 
        //         return result; 
        //     }
        //     map.put(left, i); 
        // }
        // return result; 

        HashMap<Integer, Integer> map = new HashMap<>(); 
        int[] result = new int[2]; 
        for(int i = 0; i< n; i++){
            if(!map.isEmpty() && map.containsKey(target - arr[i])){
                result[0] = i; 
                result[1] = map.get(target-arr[i]);
                return result; 
            }
            map.put(arr[i], i); 
        }
        return result; 
    }
    
}
