package Arrays;

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {12,6,1,2,7}; 
        int secondLargest = secondLargestII(arr); 
        System.out.println(secondLargest);
    }
    /*
     * Better approach
     * Time complexity: O(2N) 
     * Space complexity: O(1) (extra space complexity)
     */
    public static int secondLargestI(int[] arr){
        int largest = Integer.MIN_VALUE; 
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > largest){
                largest = arr[i]; 
            }
        }
        int secondLargest = Integer.MIN_VALUE; 
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > secondLargest && arr[i] != largest){
                secondLargest = arr[i]; 
            }
        }
        return secondLargest; 
    }
    /*
     * Optimal approach: 
     * Time complexity: O(N) 
     * Space complexity: O(1) (extra space complexity)
     */
    public static int secondLargestII(int[] arr){
        int largest = arr[0];  
        int secondLargest = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= largest){
                secondLargest = largest; 
                largest = arr[i];
            }
            if(arr[i] <= largest && arr[i] >= secondLargest){
                secondLargest = arr[i]; 
            }
        }
        return secondLargest; 
    }
    
}
