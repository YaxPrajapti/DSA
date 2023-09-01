package Arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsicutiveSubsequence {
    public static void main(String[] args) {
        // int[] arr = {2,6,1,9,4,5,3}; 
        int[] arr = {1,9,3,10,4,20,2};  
        int longestConSubSeq = findLongestConseqSubseq(arr); 
        System.out.println(longestConSubSeq);
    }
    public static int findLongestConseqSubseq(int[] arr){
        Set<Integer> set = new HashSet<>(); 
        for(int i = 0; i < arr.length; i++){
            set.add(arr[i]); 
        }
        int longest = 1; 
        for(int i : set){
            //this is the starting point of consecutive subsequence. 
            if(!set.contains(i-1)){
                int count = 1; 
                int x = 1; 
                while(set.contains(i + x)){
                    x = x + 1; 
                    count = count + 1; 
                }
                longest = Math.max(longest, count); 
            }
        }
        return longest; 
    }
}
