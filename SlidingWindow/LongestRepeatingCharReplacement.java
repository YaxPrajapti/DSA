package SlidingWindow;

import java.util.HashMap;

public class LongestRepeatingCharReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        int count = characterReplacement(s, k);
        System.out.println(count);
    }
    public static int characterReplacement(String s, int k){
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int len = 0;
        int maxValueCount = 0;
        int n = s.length();
        while (end < n){
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            maxValueCount = Math.max(map.get(ch), maxValueCount);

            while ((end-start+1) - maxValueCount > k){
                //we need to shrink the window
                map.put(s.charAt(start), map.get(s.charAt(start))-1);
                start++;
            }
            len = Math.max(end-start+1, len);
            end++;
        }
        return len;
    }
}
