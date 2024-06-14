package Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3}; 
        reverse(arr);   
        for(int i : arr){
            System.out.print(i);
        }
    } 
    public static void reverse(int[] arr){
        int i = 0; 
        int j = arr.length-1; 
        while(i < j){
            swap(i , j, arr); 
            i++; 
            j--; 
        }
    }
    private static void swap(int i, int j, int[] arr){
        int temp = arr[i]; 
        arr[i] = arr[j]; 
        arr[j] = temp; 
    }
}
