package Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] arr = {2,0,1}; 
        ductchNationalFlagAlgo(arr);
        for(int i: arr){
            System.out.print(i + " ");
        }
    }
    //this is optimal solution; 
    public static void ductchNationalFlagAlgo(int[] arr){
        int n = arr.length;
        int low = 0; 
        int mid = 0; 
        int high = n-1;
        while(mid <= high){
            //case 1; 
            if(arr[mid] == 0){
                swap(mid, low, arr); 
                mid++; 
                low++; 
            }
            //case 2
            else if(arr[mid] == 1){ 
                mid++;
            }
            //case 3
            else {
                swap(mid, high, arr); 
                high--; 
            }
        }
    }  
    private static void swap(int a, int b, int[] arr){
        int temp = arr[b]; 
        arr[b] = arr[a]; 
        arr[a] = temp; 
    }

    //this is better solution; 
    public static void sortColors(int[] arr){
        int count0 = 0; 
        int count1 = 0; 
        int count2 = 0; 
        for(int i : arr){
            if(i == 0){
                count0 = count0 + 1;
            }
            if(i == 1){
                count1 = count1 + 1; 
            }
            if(i == 2){
                count2 = count2 + 1;
            }
        }
        int index = 0; 
        while(index < arr.length){
            for(int i = 0; i < count0; i++){
                arr[index] = 0;
                index++; 
            }
            for(int i = 0; i < count1; i++){
                arr[index] = 1; 
                index++;
            }
            for(int i = 0; i < count2; i++){
                arr[index] = 2; 
                index++; 
            }
        }
    }
}

