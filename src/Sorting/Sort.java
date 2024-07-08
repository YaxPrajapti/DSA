package Sorting;

import java.util.ArrayList;


public class Sort {
    int[] arr;
    int n;

    Sort(int[] arr) {
        this.arr = arr;
        this.n = arr.length;
    }

    public void printArray() {
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
    }

    /*
     * Time complexity: O(n2)
     * Space complexity: O(1)
     * Selection algo will not make more than N swaps. So it is usefull when memory
     * writing cost is high.
     * Works well with small dataset.
     * Easy to understand.
     * It is not stable algo.
     * Will not work efficiently with large dataset.
     * In place algorithm. We are using the given array it self.
     */
    public void selectionSort() {
        for (int i = 0; i < n; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        this.printArray();
    }

    /*
     * Time complexity: O(n2)
     * space complexity: O(1)
     */
    public void bubbleSort() {
        boolean swapped = false;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        this.printArray();
    }

    /*
     * time complexity: O(n2)
     * space complexity: O(1)
     * Stable algorithm. 
     * Efficient for small data and nearly sorted data. 
     * Use when list is nearly sorted
     */
    public void insertionSort() {
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        this.printArray();
    }


    /*
     * Time complexity: O(nlogn)
     * You are dividing the array for log n times and then merging them will take O(n)
     */
    public void mergeSort(){
        int low = 0; 
        int high = n; 
        sort(arr, low, high); 
    }
    public void sort(int[] arr, int low, int high){
        if(low== high){
            return; 
        }
        int mid = (int) (low + high)/2; 
        sort(arr, low, mid);
        sort(arr, mid+1, high); 
        merge(arr, low, mid, high); 
    }
    private void merge(int[] arr, int low, int mid, int high){
        int i = low; 
        int j = mid+1; 
        ArrayList<Integer> temp = new ArrayList<>(); 
        while (i <= mid && j <= high) {
            if(arr[i] <= arr[j]){
                temp.add(arr[i]); 
                i++; 
            }else{
                temp.add(arr[j]); 
                j++; 
            }
        }
        while (i <= mid) {
            temp.add(arr[i]); 
            i++; 
        }
        while (j <= high) {
            temp.add(arr[j]); 
            j++; 
        }
        for(int index = low; index <= high; index++){
            arr[index] = temp.get(index-low); 
        }
    }
}
