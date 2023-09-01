package Arrays;

import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        // int[] arr = {2,2,1,1,1,2,2};
        int[] arr = {3,2,3}; 
        // int majority = majorityNumber(arr); 
        // System.out.println(majority);
        int majority = moorsVoteAlgo(arr); 
        System.out.println(majority);
    }
    //this is optimal; 
    public static int moorsVoteAlgo(int[] arr){
        int n = arr.length; 
        int count = 0; 
        int element = 0; 
        for(int i : arr){
            if(count == 0){
                element = i; 
                count++; 
            }else if(i == element){
                count++; 
            }else{
                count--; 
            }
        }
        int count1 = 0; 
        for(int i : arr){
            if(i == element){
                count++; 
            }
        }
        if(count1 > (n/2)){
            return -1; 
        }
        return element; 
    }

    //this is better approach;
    public static int majorityNumber(int[] arr){
        int n = arr.length; 
        if(n == 1){
            return arr[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>(); 
        int limit = (int) Math.floor(n/2);
        for(int i : arr){
            if(map.containsKey(i)){
                int value = map.get(i); 
                map.put(i, value+1);
                if(map.get(i) > limit){
                    return i; 
                }
            }else{
                map.put(i, 1); 
            }
        }
        return -1;
    }
}
