package Recursion.SubSequences;

public class CheckSubsequenceSum {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 2 };
        int k = 3;
        int N = arr.length; 
        boolean doesExist = checkSubsequenceSum(N, arr, k); 
        System.out.println(doesExist);
    }
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        // code here
        int index = 0; 
        int sum = 0; 
        return generate(N, arr, K, index, sum); 
      }
      private static boolean generate(int N, int[] arr, int K, int index, int sum){
          if(index == arr.length){
              if(sum == K){
                  return true; 
              }
            return false; 
          }
          sum += arr[index]; 
          if(generate(N, arr, K, index+1, sum) == true){
              return true; 
          }
          sum -= arr[index]; 
          if(generate(N, arr, K, index+1, sum) == true){
              return true; 
          } 
          return false; 
      }
}
