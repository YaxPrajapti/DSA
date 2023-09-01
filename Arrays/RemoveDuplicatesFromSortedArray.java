package Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,2,3,3,4,4,5}; 
        int distinctElements = removeDuplicates(arr); 
        System.out.println(distinctElements);
    }
    public static int removeDuplicates(int[] arr){
        int i = 0;
        int j = i+1;   
        while(j < arr.length){
            if(arr[i] == arr[j]){
                j++; 
            }else{
                i++;
                arr[i] = arr[j]; 
            }
        }
        return i+1;
    }
}
