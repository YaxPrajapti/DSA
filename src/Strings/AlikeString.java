package Strings;

import java.util.HashSet;
import java.util.Set;

public class AlikeString {
    static final Set<Character> s = new HashSet<>(); 
    public static void main(String[] args) {
        String s = "book"; 
        boolean alike = halvesAreAlike(s); 
        System.out.println(alike);
    }
    public static boolean halvesAreAlike(String str){
        s.add('a'); 
        s.add('e'); 
        s.add('i');
        s.add('o');
        s.add('u'); 
        s.add('A'); 
        s.add('E'); 
        s.add('I'); 
        s.add('O'); 
        s.add('U'); 
        int firstHalf = 0; 
        for(int i = 0; i < str.length()/2; i++){
            if(s.contains(str.charAt(i))){
                firstHalf++; 
            }
        }
        int secondhalf = 0; 
        for(int i = str.length()/2; i < str.length(); i++){
            if(s.contains(str.charAt(i))){
                secondhalf++; 
            }
        }
        return (firstHalf == secondhalf) ? true : false; 
    }
}
