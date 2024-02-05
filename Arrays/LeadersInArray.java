package Arrays;

import java.util.ArrayList;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = {1,2,2,1}; 
        ArrayList<Integer> leader = findLeadersInArray(arr); 
        System.out.println(leader);
    }
    public static ArrayList<Integer> findLeadersInArray(int[] arr){
        int leader = 0; 
        int n = arr.length; 
        ArrayList<Integer> ans = new ArrayList<>(); 
        for(int i = n-1; i >= 0; i--){
            if(arr[i] > leader){
                leader = arr[i];    
                ans.add(0, arr[i]); 
            }
        }
        return ans; 
    }
}
