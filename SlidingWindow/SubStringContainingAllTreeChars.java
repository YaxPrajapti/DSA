package SlidingWindow;

import java.util.HashMap;

public class SubStringContainingAllTreeChars {
    public static void main(String[] args) {
        String s = "abcabc";
        int ans = numberOfSubstrings(s);
        System.out.println(ans);
    }
    public static int numberOfSubstrings(String s){
        int start = 0;
        int end = 0;
        int a = 0;
        int b = 0;
        int c = 0;
        int n = s.length();
        int count = 0;
        while(end < n){
            char ch = s.charAt(end);
            if(ch == 'a'){
                a++;
            }else if(ch == 'b'){
                b++;
            }else if(ch == 'c'){
                c++;
            }
            while(a >= 1 && b >=1 && c>=1){
                count += n - end;
                if(s.charAt(start) == 'a'){
                    a--;
                }
                if(s.charAt(start) == 'b'){
                    b--;
                }
                if(s.charAt(start) == 'c'){
                    c--;
                }
                start++;
            }
            end++;
        }
        return count;
//        int start = 0;
//        int end = 0;
//        int n = s.length();
//        HashMap<Character, Integer> map = new HashMap<>();
//        int count = 0;
//        while (end < n){
//            char ch = s.charAt(end);
//            map.put(ch, map.getOrDefault(ch, 0)+1);
//            while (map.getOrDefault('a', 0) >= 1 && map.getOrDefault('b', 0) >= 1 && map.getOrDefault('c', 0) >= 1){
//                count += n - end; // this is the count of numbers of possible substring containing at least one occurrence of a, b and c.
//                map.put(s.charAt(start),map.get(s.charAt(start))-1);
//                start++;
//            }
//            end++;
//        }
//        return count;
    }
}
