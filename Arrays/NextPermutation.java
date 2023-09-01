package Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {1,1,5}; 
        nextPermutaion(arr);
        for(int i : arr){  
            System.out.print(i + " ");
        }
    }
    public static void nextPermutaion(int[] arr){
        int index = -1; 
        int n = arr.length; 
        //find the dip. 
        for(int i = n-2; i >= 0; i--){
            if(arr[i] < arr[i+1]){
                index = i; 
                break; 
            }
        }
        //if there is no dip then just reverse the array. 
        if(index == -1){
            reverse(0, n-1, arr); 
            return; 
        }
        int toBeSwapped = -1; 
        for(int i = n-1; i > index; i--){
            if(arr[i] > arr[index]){
                toBeSwapped = i; 
                swap(toBeSwapped, index, arr); 
                reverse(index+1, n-1, arr);
                break;  
            }
        }
    }
    private static void swap(int i, int j, int[] arr){
        int temp = arr[i]; 
        arr[i] = arr[j]; 
        arr[j] = temp; 
    }
    private static void reverse(int i, int  j, int[] arr){
        int start = i; 
        int end = j; 
        while(start < end){
            swap(start, end, arr);
            start++; 
            end--; 
        }
    }
}
