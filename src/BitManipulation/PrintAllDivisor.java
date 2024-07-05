package BitManipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintAllDivisor {
    public static void main(String[] args) {
        int n = 20; 
        print_divisors(n); 
    }
    public static void print_divisors(int n) {
        List<Integer> list = new ArrayList<>(); 
        for(int i = 1; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                list.add(i); 
                if((n/i) != i){
                    list.add(n/i); 
                }
            }
        }
        Collections.sort(list); 
        System.out.println(list);
    }
}
