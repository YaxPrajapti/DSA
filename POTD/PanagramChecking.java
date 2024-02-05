package POTD;

import java.util.HashSet;
import java.util.Set;

public class PanagramChecking {
    public static void main(String[] args) {
        boolean ans = checkPangram("sdfs");
        System.out.println("ans = " + ans);
    }
    public static boolean checkPangram  (String s){
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            set.add(Character.toUpperCase(ch));
        }
        for(char c = 'A'; c < 'Z'; c++){
            if(!set.contains(c)){
                return false;
            }
        }
        return true;
    }
}
