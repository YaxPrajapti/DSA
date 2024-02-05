package Arrays;

import java.util.HashMap;

public class SumWithXORk {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4}; 
        int k =6; 
        int count = countSubArrayWithXor(arr, k); 
        System.out.println(count);
    }
    public static int countSubArrayWithXor(int[] arr, int k){
        int xr = 0; 
        int count = 0; 
        HashMap<Integer, Integer> map = new HashMap<>(); 
        map.put(0, 1); 
        for(int i = 0; i < arr.length; i++){
            xr = xr ^ arr[i]; 
            count += map.getOrDefault(xr ^ k, 0); 
            if(map.containsKey(xr)){
                map.replace(xr, map.get(xr) + 1); 
            }else{
                map.put(xr, 1); 
            }
        }
        return count; 
    }
}
