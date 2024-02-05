package BinarySearch;

import java.util.ArrayList;

public class PaintersProblem {
    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        int k =2; 
        ArrayList<Integer> boards = new ArrayList<>();
        for(int i : arr){
            boards.add(i); 
        }
        int ans = findLargestMinDistance(boards, k); 
        System.out.println(ans);
         
    }
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k){
        int maxi = Integer.MIN_VALUE; 
        int maxSum = 0; 
        for(int i : boards){
            maxi = Math.max(maxi, i); 
            maxSum += i; 
        }
        int l = maxi; 
        int h = maxSum; 
        int ans = Integer.MAX_VALUE; 
        while(l <= h){
            int mid = (int)(l+h)/2; 
            if(possible(boards, k, mid)){
                h = mid - 1; 
                ans = Math.min(ans, mid); 
            }else{
                l = mid + 1; 
            }
        }
        return ans; 
    }
    private static boolean possible(ArrayList<Integer> boards, int k, int limit){
        int count = 1; 
        int sum = 0; 
        for(int i = 0; i < boards.size(); i++){
            if(sum + boards.get(i) > limit){
                count++; 
                sum = boards.get(i); 
            }else{
                sum = sum + boards.get(i); 
            }
        }
        return (count > k) ? false : true; 
    }
}
