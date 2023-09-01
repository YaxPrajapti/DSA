package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] arr = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296; 
        List<List<Integer>> ans = fourSum(arr, target); 
        System.out.println(ans);
    }
    public static List<List<Integer>> fourSum(int[] arr, int target){
        List<List<Integer>> ans = new ArrayList<>(); 
        Arrays.sort(arr); 
        int n = arr.length; 
        for(int i = 0; i < n; i++){
            //remove duplicate from calculation; 
            if(i > 0 && arr[i] == arr[i-1]){
                continue; 
            }
            for(int j = i+1; j < n; j++){
                //remove duplicates from calculation; 
                if(j != i + 1 && arr[j-1] == arr[j]){
                    continue; 
                }
                int k = j + 1; 
                int l = n - 1; 
                while(k < l){
                    long sum = arr[i]; 
                    sum = sum + arr[j] + arr[k] + arr[l]; 
                    if(sum == target){
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]); 
                        ans.add(temp); 
                        k++; 
                        while(k < l && arr[k] == arr[k-1]) k++; 
                        l--; 
                        while(k < l && arr[l] == arr[l+1]) l--; 
                    }
                    else if(sum < target){
                        k++; 
                    }else{
                        l--; 
                    }
                }
            }
        }
        return ans; 
    }
}
