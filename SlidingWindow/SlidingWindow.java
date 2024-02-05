package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class SlidingWindow {
    public static void main(String[] args) {
        String s = "dvdf";
        int ans = lengthOfLongestSubstring(s);
        System.out.println(ans);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int len = 0;
        int maxi = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        while (end < n) {
            char ch = s.charAt(end);
            if (!set.contains(ch)) {
                set.add(ch);
                end++;
                len = end - start;
            } else {
                while (set.contains(ch)) {
                    set.remove(s.charAt(start));
                    start++;
                }
                maxi = Math.max(len, maxi);
                len = end - start;
            }

        }
        maxi = Math.max(maxi, end - start);
        return maxi;
    }
}
