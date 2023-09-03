package Arrays;

import java.util.ArrayList;

public class InversionCount {
    public static void main(String[] args) {
        int[] arr = {2,4,1,3,5}; 
        int countOfInversion = inversionCount(arr); 
        System.out.println(countOfInversion);
    }
    //optimal approach; 
    /*
     * using merge sort 
     * time complexity: O(NlogN)
     * space complexity: O(N) 
     */
     
    
    private static int merge(int[] arr, int low, int mid, int high) {
        int count = 0; 
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            }
            //if right is smaller  
            else {
                temp.add(arr[right]);
                count += mid-left+1; 
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        return count; 
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int count = 0; 
        if (low >= high) return count;
        int mid = (low + high) / 2 ;
        count += mergeSort(arr, low, mid);  // left half
        count += mergeSort(arr, mid + 1, high); // right half
        count += merge(arr, low, mid, high);  // merging sorted halves
        return count; 
    }
    public static int inversionCount(int[] arr){
        int n = arr.length; 
        return mergeSort(arr, 0, n-1);
    }

    //bruteForce approach 
    /*
     * time complexity : (O(N^2))
     * space complexity: O(N^)
     */
    public static int countOfInversionBruteForce(int[] arr){
        int n = arr.length; 
        int count = 0; 
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(arr[i] > arr[j]){
                    count++; 
                }
            }
        }
        return count; 
    }
}
