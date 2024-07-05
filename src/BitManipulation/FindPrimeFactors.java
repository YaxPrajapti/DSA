package BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class FindPrimeFactors {
    public static void main(String[] args) {
        int[] ans = AllPrimeFactors(2); 
        for(Integer i : ans){
            System.out.print(i + " ");
        }
    }
    public static int[] AllPrimeFactors(int N){
        List<Integer> list = new ArrayList<>(); 
        for(int i = 2; i <= Math.sqrt(N); i++){
            if(N % i == 0){
                list.add(i); 
                while (N % i == 0) {
                    N = N / i; 
                }
            }
        }
        if(N != 1){
            list.add(N); 
        }
        int size = list.size(); 
        int[] ans = new int[size]; 
        for(int i = 0; i < size; i++){
            ans[i] = list.get(i); 
        }
        return ans; 
    }
}
