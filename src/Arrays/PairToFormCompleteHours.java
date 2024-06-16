package Arrays;

import java.util.HashMap;
import java.util.Map;

public class PairToFormCompleteHours {
    public static void main(String[] args) {
        int[] hours = {18,6,30,24,24}; 
        long ans = countCompleteDayPairs(hours); 
        System.out.println(ans);
    }
    public static long countCompleteDayPairs(int[] hours) {
        Map<Long, Integer> map = new HashMap<>(); 
        long count = 0; 
        for(Integer i : hours){
            count += map.getOrDefault((long)(i%24), 0); 
            long curr_hours_remaining = (long)((24 - (i % 24))%24);
            map.put(curr_hours_remaining, map.getOrDefault(curr_hours_remaining, 0) + 1); 
        }
        return count; 
    }
}
