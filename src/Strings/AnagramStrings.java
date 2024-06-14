package Strings;

import java.util.HashMap;
import java.util.HashSet;

public class AnagramStrings {
    public static void main(String[] args) {
        // String s = "rat"; 
        // String t = "car"; 
        String s = "aacc"; 
        String t = "ccac"; 
        boolean isAna = isAnagram(s, t); 
        System.out.println(isAna);
    }
    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false; 
        }
        HashMap<Character, Integer> map1 = new HashMap<>(); 
        HashMap<Character, Integer> map2 = new HashMap<>(); 
        insertIntoMap(map1, s); 
        insertIntoMap(map2, t); 
        System.out.println(map1);
        System.out.println(map2);
        if(map1.equals(map2)){
            return true; 
        }
        return false; 
    }
    private static void insertIntoMap(HashMap<Character, Integer> map, String s){
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.replace(s.charAt(i), map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i), 1); 
            }
        }
    }
}
