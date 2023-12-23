package POTD;

import java.util.HashMap;

public class Dec23 {
    public static void main(String[] args) {
        // int n = 8; 
        // int[] arr = {3,1,2,2,1,2,3,3}; 
        // int k = 4; 
        int n = 4; 
        int[] arr = {2,3,3,2}; 
        int k = 3; 
        int count = countOccurence(arr, n, k); 
        System.out.println(count);

    }
    public static int countOccurence(int[] arr, int n, int k){
        HashMap<Integer, Integer> map = new HashMap<>(); 
        int threshould = n/k; 
        for(int i : arr){
            if(map.containsKey(i)){
                map.replace(i, map.get(i)+1); 
            }else{
                map.put(i, 1); 
            }
        }
        int count = 0; 
        for(int i : map.keySet()){
            int freq = map.get(i); 
            if(freq > threshould){
                count++; 
            }
        }
        return count; 
    }
}
