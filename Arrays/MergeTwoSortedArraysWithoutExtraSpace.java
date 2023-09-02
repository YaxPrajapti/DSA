package Arrays;

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace {
    public static void main(String[] args) {
        long[] arr1 = {0,1,2}; 
        long[] arr2 = {3,4,5,6};
        int n = arr1.length; 
        int m = arr2.length; 
        merge(arr1, arr2, n, m);
        for(long i : arr1){
            System.out.print(i + " ");
        }
        System.out.println();
        for(long i : arr2){
            System.out.print(i + " ");
        }

    }
    public static void merge(long[] arr1, long[] arr2, int n, int m){
        int left = n -1; 
        int right = 0; 
        while(left >= 0 && right < m){
            if(arr1[left] > arr2[right]){
                long temp = arr2[right]; 
                arr2[right] = arr1[left]; 
                arr1[left] = temp; 
                left--; 
                right++; 
            }else{
                break; 
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
    
}
