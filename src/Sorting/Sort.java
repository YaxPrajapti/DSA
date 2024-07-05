package Sorting;

import java.util.Arrays;

public class Sort {
    int[] arr; 
    int n; 
    Sort(int[] arr){
        this.arr = arr; 
        this.n = arr.length; 
    }

    public void printArray(){
        for(Integer i : arr){
            System.out.print(i + " ");
        }
    }
    /*
     * Time complexity: O(n2)
     * Space complexity: O(1)
     * Selection algo will not make more than N swaps. So it is usefull when memory writing cost is high.
     */
    public void selectionSort(){
        for(int i = 0; i < n; i++){
            int min = arr[i]; 
            int minIndex = i; 
            for(int j = i+1; j < n; j++){
                if(arr[j] < min){
                    min = arr[j]; 
                    minIndex = j; 
                }
            }
            int temp = arr[i]; 
            arr[i] = arr[minIndex]; 
            arr[minIndex] = temp; 
        }
    }


}
