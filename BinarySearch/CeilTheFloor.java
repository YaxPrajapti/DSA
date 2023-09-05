package BinarySearch;

import java.util.Arrays;

public class CeilTheFloor {
    static class Pair{
        int floor; 
        int ceil; 
        Pair(){
            this.floor = 0; 
            this.ceil = 0; 
        }
        Pair(int floor, int ceil){
            this.floor = floor; 
            this.ceil = ceil; 
        }
    }
    public static void main(String[] args) {
        int[] arr = {5, 6, 8, 9, 6, 5, 5, 6}; 
        Pair ans = ceilAndFloor(arr, arr.length, 10); 
        System.out.println(ans.floor);
        System.out.println(ans.ceil);
    }

    //this is in o(n); 
    //for unsorted array; 
    //for sorted array we can use lower bound and upper bound concept. 
    public static Pair ceilAndFloor(int[] arr, int n, int x){
        int floor = -1;  
        int ceil = Integer.MAX_VALUE; 
        for(int i = 0; i < n; i++){
            if(arr[i] <= x && arr[i] >= floor){
                floor = arr[i]; 
            }
            if(arr[i] >= x && arr[i] <= ceil){
                ceil = arr[i]; 
            }
        }
        if(ceil == Integer.MAX_VALUE){
            ceil = -1; 
        }
        Pair ans = new Pair(); 
        ans.floor = floor; 
        ans.ceil = ceil; 
        return ans; 
    }
}
