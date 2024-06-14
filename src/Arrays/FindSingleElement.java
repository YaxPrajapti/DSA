package Arrays;

public class FindSingleElement {
    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2}; 
        int single = findSingle(arr); 
        System.out.println(single);
    }
    public static int findSingle(int[] arr){
        int xor = 0; 
        for(int i = 0; i < arr.length; i++){
            xor = xor ^ arr[i];
        }
        return xor; 
    }
}
