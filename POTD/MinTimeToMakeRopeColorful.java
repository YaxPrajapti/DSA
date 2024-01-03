package POTD;

import java.util.ArrayList;
import java.util.Collections;

public class MinTimeToMakeRopeColorful {

    public static void main(String[] args) {
        String colors = "aaabbbabbbb";
        int[] neededTime = { 3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1 };
        int minCost = minCost(colors, neededTime);
        System.out.println(minCost);
    }

    public static int minCost(String colors, int[] neededTime) {
        int time = 0; 
        for(int i = 0; i <colors.length()-1; i++){
            if(colors.charAt(i) == colors.charAt(i+1)){
                if(neededTime[i] <= neededTime[i+1]){
                    time += neededTime[i]; 
                }
                else{
                    time += neededTime[i+1]; 
                    neededTime[i+1] = neededTime[i]; 
                }
            }
        }
        return time; 
    }
}
