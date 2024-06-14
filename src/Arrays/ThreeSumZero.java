package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ThreeSumZero {
    public static void main(String[] args) {
        int[] arr = {-2,0,1,1,2}; 
        List<List<Integer>> ans = thresumOptimal(arr); 
        System.out.println(ans);
    }
    //optimal solution: 
    public static List<List<Integer>> thresumOptimal(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            //remove duplicates:
            if (i != 0 && arr[i] == arr[i - 1]) continue;

            //moving 2 pointers:
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    //skip the duplicates:
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                }
            }
        }

        return ans;
    }
    //better Solution; 
    public static List<List<Integer>> threeSum(int[] arr){
        HashSet<ArrayList<Integer>> ans = new HashSet<>(); 
        for(int i = 0; i < arr.length; i++){
            HashSet<Integer> set = new HashSet<>(); 
            for(int j = i+1; j < arr.length; j++){
                int third = -(arr[i] + arr[j]); 
                if(set.contains(third)){
                    ArrayList<Integer> temp = new ArrayList<>(); 
                    temp.add(arr[i]); 
                    temp.add(arr[j]); 
                    temp.add(third);
                    Collections.sort(temp); 
                    ans.add(temp); 
                }
                set.add(arr[j]); 
            }
        }
        return new ArrayList<>(ans); 
    }
}
