package Arrays;

public class IsArraySorted {
    public static void main(String[] args) {
        int[] arr = {2,2,2,2,2}; 
        boolean isSorted = isSorted(arr); 
        System.out.println(isSorted);
    }
    public static boolean isSorted(int[] arr){
        int count = 0; 
        for(int i = 1; i < arr.length; i++){
            if(arr[i-1] <= arr[i]){
                count++; 
            }
        }
        return count == arr.length-1; 
    }
}
