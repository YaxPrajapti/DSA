package Arrays;

import java.util.HashMap;
import java.util.HashSet;

public class LargestSubArrayWithSumZero {
    public static void main(String[] args) {
        int[] arr = {-1,1,-1,1};
        int n = arr.length; 
        int maxlen = maxlen(arr, n); 
        System.out.println(maxlen);
    }
    //use the presum concept. 
    public static int maxlen(int[] arr, int n){
        int presum = 0; 
        int len = 0; 
        HashMap<Integer, Integer> map = new HashMap<>(); 
        for(int i = 0; i < n; i++){
            presum = presum + arr[i]; 
            if(map.containsKey(presum)){
                len = Math.max(len, i - map.get(presum)); 
            }
            else if(presum == 0){
                len = Math.max(i+1, len); 
            }
            else{
                map.put(presum, i); 
            }
            
        }
        return len; 
    }
}
