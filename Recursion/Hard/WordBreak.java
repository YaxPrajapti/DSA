package Recursion.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String s = "catsandog"; 
        String[] wordDict = {"cats", "dog", "sand", "and", "cat"}; 
        boolean possible = wordBreak(s, Arrays.asList(wordDict)); 
        System.out.println(possible);
    }
    public static boolean wordBreak(String s, List<String> wordDict){
        int index = 0; 
        for(int i = 0; i < wordDict.size(); i++){
            String word = wordDict.get(i); 
            for(int j = 0; j < word.length(); j++){
                if(word.charAt(j) != s.charAt(index)) return false; 
                index++; 
            }
        }
        return true; 
    }
}
