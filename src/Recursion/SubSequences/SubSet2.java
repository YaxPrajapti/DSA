package Recursion.SubSequences;
import java.util.*; 
public class SubSet2 {
    public static void main(String[] args) {
        int[] arr = {1,2,2}; 
        List<List<Integer>> subsetsWithDup = subsetsWithDup(arr); 
        System.out.println(subsetsWithDup);
    }
    public static List<List<Integer>> subsetsWithDup(int[] arr){
        Arrays.sort(arr); 
        int index = 0; 
        List<List<Integer>> ans = new ArrayList<>();  
        generate(arr, index, ans, new ArrayList<>()); 
        return ans; 
    }
    private static void generate(int[] arr, int index, List<List<Integer>> ans, List<Integer> temp){        
        ans.add(new ArrayList<>(temp)); 
        for(int i = index; i < arr.length; i++){
            if(i > index && arr[i] == arr[i-1]){
                continue; 
            }
            temp.add(arr[i]); 
            generate(arr, i+1, ans, temp);
            temp.remove(temp.size()-1);
        }
    }
}
