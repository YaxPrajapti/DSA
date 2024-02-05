package Arrays;

import java.util.Arrays;

public class MaxProfitInJobScheduling {
    public static void main(String[] args) {
        int[] startTime = {1,2,3,4,6}; 
        int[] endTime = {3,5,10,6,9}; 
        int[] profit = {20,20,100,70,60}; 
        int max_profit = jobScheduling(startTime, endTime, profit); 
        // System.out.println(startTime.length);
        System.out.println(max_profit);
    }
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit){
        int n = startTime.length; 
        int[][] jobs = new int[n][3]; 
        for(int i = 0; i < jobs.length; i++){
            jobs[i][0] = startTime[i]; 
            jobs[i][1] = endTime[i]; 
            jobs[i][2] = profit[i]; 
        }
        Arrays.sort(jobs, (x,y) -> x[0]-y[0]);
        int[] memo = new int[50001]; 
        Arrays.fill(memo, -1);
        return schedule(jobs, n, 0, memo);  
    }
    // private static int schedule(int[][] jobs, int n, int index, int[] memo, int curr_profit){
    //     if(index == n){
    //         return 0; 
    //     }
    //     if(memo[index] != -1){
    //         return memo[index]; 
    //     }
    //     int curr_job_endTime = jobs[index][1]; 
    //     int next_job_index = findNextJob(jobs, curr_job_endTime); 
    //     //chose 
    //     curr_profit += jobs[index][2]; 
    //     int chose = schedule(jobs, n, next_job_index, memo, curr_profit); 
    //     curr_profit -= jobs[index][2];  
    //     //not chose 
    //     int notChoose = schedule(jobs, n, index+1, memo, curr_profit); 
    //     return Math.max(notChoose, chose); 
    // }
    private static int schedule(int[][] jobs, int n, int index, int[] memo){
        if(index == n){
            return 0; 
        }
        if(memo[index] != -1){
            return memo[index]; 
        }
        int curr_job_endTime = jobs[index][1]; 
        int next_job_index = findNextJob(jobs, curr_job_endTime); 
        int max_profit = Math.max(schedule(jobs, n, index+1, memo), schedule(jobs, n, next_job_index, memo)+jobs[index][2]); 
        memo[index] = max_profit; 
        return max_profit; 
    }
    private static int findNextJob(int[][] jobs, int curr_job_endTime){
        int start = 0; 
        int end = jobs.length-1; 
        int next_job_index = jobs.length; 
        while (start <= end) {
            int mid = (int)(start+end)/2;
            if(jobs[mid][0] >= curr_job_endTime){
                next_job_index = mid; 
                end = mid-1; 
            }else{
                start = mid + 1; 
            }
        }
        return next_job_index; 
    }
}
