package Strings;

import java.util.*;

public class IsomorphicString {
    public static void main(String[] args) {
        String s = "ab";
        String t = "ac";
        boolean isIso = isIsomorphic(s, t);
        System.out.println(isIso);
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s.equals(t)){
            return true; 
        }
        HashMap<Character, Character> map = new HashMap<>();
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
             
            i++;
            j++;
        }
        System.out.println(map);
        StringBuilder st = new StringBuilder();
        for (int k = 0; k < s.length(); k++) {
            char ch = s.charAt(k);
            st.append(map.get(ch));
        }
        if (t.equals(st.toString())) {
            return true;
        }
        return false;
    }
}
