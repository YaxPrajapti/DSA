package BinarySearch;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {0,0,0,0,0}; 
        int[] arr2 = {-1,0,0,0,0,0,1}; 
        double median = findMedianSortedArrays(arr1, arr2); 
        System.out.println(median);
    }
    
    public static double findMedianSortedArrays(int[] arr1, int[] arr2){
        int n = arr1.length; 
        int m = arr2.length; 
        int i = 0; 
        int j = 0; 
        int k = 0; 
        int[] merged = new int[n+m];
        //merge two arrays. 
        while(i < n && j < m){
            if(arr1[i] < arr2[j]){
                merged[k] = arr1[i];
                i++; 
            }
            else if(arr1[i] > arr2[j]){
                merged[k] = arr2[j];
                j++; 
            }else{
                merged[k] = arr1[i];
                i++; 
                k++; 
                merged[k] = arr2[j];
                j++; 
            }
            k++; 
        }
        while(i < n){
            merged[k] = arr1[i]; 
            i++;
            k++; 
        }
        while(j < m){
            merged[k] = arr2[j]; 
            j++; 
            k++; 
        }
        for(int ele : merged){
            System.out.println(ele + " ");
        }
        //find median 
        if((m+n) % 2 == 1){
            return (double)(merged[(m+n)/2]); 
        }else{
            int midIndex = (m+n)/2; 
            double firstNumber = merged[midIndex-1];
            double secondNumber = merged[midIndex]; 
            double median = (firstNumber+secondNumber)/2; 
            return median; 
        }
    }
     
}
