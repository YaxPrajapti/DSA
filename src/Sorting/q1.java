package Sorting;

public class q1 {
    public static void main(String[] args) {
        int[] arr = {0,1,0,1,0}; 
        int ans = numberOfAlternatingGroups(arr); 
        System.out.println(ans);
    }
    public static int numberOfAlternatingGroups(int[] arr) {
        int n = arr.length; 
        int count = 0; 
        for(int i = 0; i < n; i++){
            int next = (i+1)%n; 
            int next_next = (i+2)%n; 
            int curr = arr[i]; 
            int curr_next = arr[next]; 

            if(arr[i] != arr[next] && arr[next] != arr[next_next] && arr[next_next] == arr[i]){
                count++;
            }
        }
        return count; 
    }
}
