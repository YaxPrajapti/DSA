package Sorting;

public class Main {
    public static void main(String[] args) {
        Sort selectionSort = new Sort(new int[]{64,25,12,22});
        selectionSort.selectionSort(); 
        System.out.println();
        Sort bubbleSort = new Sort(new int[]{64,25,12,22}); 
        bubbleSort.bubbleSort();
        System.out.println();
        Sort insertionSort = new Sort(new int[]{64,25,12,22}); 
        insertionSort.insertionSort();
    }

}
