package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;

public class LengthOfLISUsingBS {
    public static void main(String[] args) {
        // int[] arr = {5,8,3,7,9,1}; 
        int[] arr = {1,2,3}; 
        int n = arr.length; 
        int ans=longestSubsequence(n, arr); 
        System.out.println(ans);
    }
    static int longestSubsequence(int n, int arr[]) {
        // code here
        ArrayList<Integer> list = new ArrayList<>(); 
        for(int i = 0; i < n; i++){
            int index = Collections.binarySearch(list, arr[i]); 
            if(index >= 0){
                list.set(index, arr[i]); 
            }else {
                index = Math.abs(index)-1; 
                if(index == list.size()){
                    list.add(index, arr[i]); 
                }else{
                    list.set(index, arr[i]); 
                }
            }
        }
        return list.size(); 
    }
}
