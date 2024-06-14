package SlidingWindow;

import java.util.HashMap;

public class MinWindowSubString {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String ans = minWindow(s, t);
        System.out.println("ans = " + ans);
    }
    public static String minWindow(String s, String t) {
        int start = 0;
        int end = 0;
        if (s.length() < t.length()) {
            return "";
        }
        if (s.equals(t)) {
            return s;
        }
        int n = s.length();
        int len = Integer.MAX_VALUE;
        int count = t.length();
        String ans = "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        while (end < n) {
            if (map.containsKey(s.charAt(end))) {
                if (map.get(s.charAt(end)) > 0) {
                    count--;
                }
                map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
            }
            while (count == 0) {
                if (end - start < len) {
                    len = end - start;
                    ans = s.substring(start, end + 1);
                }
                if (map.containsKey(s.charAt(start))) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                    if (map.get(s.charAt(start)) > 0) {
                        count++;
                    }
                }
                start++;
            }
            end++;
        }
        return ans;
    }
}
