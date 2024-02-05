package Arrays;

public class MoveZeorsToEnd {
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,4}; 
        movezerosToEnd(arr);
        for(int i : arr){
            System.out.println(i);
        }
    }
    public static void movezerosToEnd(int[] arr){
        int i = 0; 
        int j = i; 
        int count = 0; 
        while(j < arr.length){
            if(arr[j] == 0){
                count = count+1; 
            }else{
                arr[i] = arr[j]; 
                i++; 
            }
            j++; 
        }
        while(i < arr.length){
            arr[i] = 0; 
            i++;
        }
    }
}
