package Recursion.SubSequences;

public class CountAllSubSeqWithSumK {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2 }; 
        int k = 3; 
        int count = countSubSequence(arr, k); 
        System.out.println(count);
    }
    public static int countSubSequence(int[] arr, int k){
        int index = 0;
        int sum = 0;        
        return generate(arr, k, index, sum);
         
    }
    private static int generate(int[] arr, int k, int index, int sum) {
        //base case 
        if(index == arr.length){
            if(sum == k){
                return 1; 
            }
            return 0; 
        }
        sum = sum + arr[index]; 
        int l = generate(arr, k, index+1, sum); 
        sum = sum - arr[index]; 
        int r = generate(arr, k, index+1, sum); 
        return l + r; 
    }
}
 