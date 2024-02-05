package Arrays;

public class FindDuplicateElement {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2}; 
        int dpulicate = findDuplicate(arr); 
        System.out.println(dpulicate);
    }
    public static int findDuplicate(int[] arr){
        for(int i : arr){
            int index = Math.abs(i);
            if(arr[index] < 0){
                return index; 
            }
            arr[index] = -arr[index]; 

        }
        return 0; 
    }
}
