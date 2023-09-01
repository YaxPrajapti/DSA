package Arrays;

import java.util.ArrayList;
import java.util.List;

public class MajorityVote {
    public static void main(String[] args) {
        int[] arr = {0,0,0}; 
        List<Integer> ans = majorityElements(arr); 
        System.out.println(ans);
    }
    public static List<Integer> majorityElements(int[] arr){
        List<Integer> ans = new ArrayList<>(); 
        int count1 = 0; 
        int count2 = 0; 
        int ele1 = 0; 
        int ele2 = 0; 
        for(int i = 0; i < arr.length; i++){
            if(count1 == 0 && ele2!=arr[i]){
                count1++; 
                ele1 = arr[i]; 
            }else if(count2 == 0 && ele1 != arr[i]){
                count2++; 
                ele2 = arr[i]; 
            }else if(arr[i] == ele1){
                count1++; 
            }else if(arr[i] == ele2){
                count2++; 
            }else{
                count1--; 
                count2--; 
            }
        }
        //now check if ele1 and ele2 is actually a majority; 
        int cnt1 = 0; 
        int cnt2 = 0; 
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == ele1){
                cnt1++; 
            }
            if(arr[i] == ele2){
                cnt2++; 
            }
        }
        int limit = (int)(arr.length/3) + 1;
        if(cnt1 >= limit) {
            ans.add(0, ele1);
        }
        if(cnt2 >= limit){
            ans.add(1, ele2); 
        }
        return ans; 
    }
}
