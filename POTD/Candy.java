package POTD;

import java.util.ArrayList;
import java.util.Arrays;

public class Candy {
    public static void main(String[] args) {
        int N = 10; 
        int[] rating = {11942 ,4827 ,5436 ,32391 ,14604 ,3902 ,153 ,292 ,12382 ,17421}; 
        // int N = 3; 
        // int[] rating = {1,2,2}; 
        int minCandy = minCandy(N, rating); 
        System.out.println(minCandy);
    }
    public static int minCandy(int N, int[] rating){
        int[] candy = new int[N]; 
        Arrays.fill(candy, 1);
        
        boolean changed = true; 
        while(changed){
            changed = false; 
            for(int i = 1; i < N-1; i++){
                //check for the left 
                if(rating[i] > rating[i-1] && candy[i] <= candy[i-1]){
                    candy[i] = candy[i-1] + 1; 
                    changed=true; 
                }
                //check for the right 
                if(rating[i] > rating[i+1] && candy[i] <= candy[i+1]){
                    candy[i] = candy[i+1] + 1; 
                    changed = true; 
                }
            }
        }
        if(rating[0] > rating[1]){
            candy[0] = candy[1] + 1; 
        }
        if(rating[N-1] > rating[N-2]){
            candy[N-1] = candy[N-2] + 1; 
        }
        int minCandy = 0; 
        for(int x : candy){
            minCandy+=x; 
        }
        return minCandy; 
    }
}
