package Recursion.Basic;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9}; 
        reverseII(arr, 0, arr.length); 
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
    public static void reverse(int[] arr, int l, int r){
        if(l == r){
            return; 
        }
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp; 
        reverse(arr, l+1, r-1);
    }
    public static void reverseII(int[] arr, int i, int n){
        if(i > n/2){
            return; 
        }
        int temp = arr[i]; 
        arr[i] = arr[n-i-1]; 
        arr[n-i-1] = temp; 
        reverseII(arr, i+1, n);
    }
}
