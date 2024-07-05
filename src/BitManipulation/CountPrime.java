package BitManipulation;

import java.util.Arrays;

public class CountPrime {
    public static void main(String[] args) {
        int n =10; 
        int count = countPrimes(n); 
        System.out.println(count);
    }
    public static int countPrimes(int n) {
        int[] prime = sieve(n); 
        int count = 0; 
        for(int i = 2; i < n; i++){
            if(prime[i] == 1){
                count++; 
            }
        }
        return count; 
    }
    private static int[] sieve(int n){
        int[] prime = new int[n+1]; 
        Arrays.fill(prime, 1); 
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(prime[i] == 1){
                for(int j = i*i; j <= n; j+=i){
                    prime[j] = 0; 
                }
            }
        }
        return prime; 
    }
}
