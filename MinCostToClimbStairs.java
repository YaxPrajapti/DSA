import java.util.Arrays;

public class MinCostToClimbStairs {
    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1}; 
        int minCostClimbingStairs = minCostClimbingStairs(cost); 
        System.out.println(minCostClimbingStairs);
    }
    public static int minCostClimbingStairs(int[] cost){
        int[] costTrack = new int[cost.length]; 
        costTrack[0] = cost[0]; 
        costTrack[1] = cost[1]; 
        for(int i = 2; i < cost.length; i++){
            costTrack[i] = cost[i] + Math.min(costTrack[i-1], costTrack[i-2]); 
        }
        return Math.min(costTrack[costTrack.length-1], costTrack[costTrack.length-2]); 
    }
}
