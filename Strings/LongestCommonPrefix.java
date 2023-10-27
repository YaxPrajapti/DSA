package Strings;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        // String[] strings = {"flower","flow","flight"};
        String[] strings = {"dog","racecar","car"};  
        String prefixString = longestCommonPrefix(strings);   
        System.out.println(prefixString);
    }
    public static String longestCommonPrefix(String[] strings){
        char[] arr = strings[0].toCharArray(); 
        int count = arr.length;
        for(int i = 1; i < strings.length; i++){
            String word = strings[i]; 
            int j = 0; 
            int k = 0; 
            int windowSize = 0; 
            while (j < word.length() && k < arr.length) {
                if(word.charAt(j) == arr[k]){
                    windowSize++; 
                }else{
                    break; 
                }
                j++; 
                k++; 
            }
            System.out.println("Count: " + count);
            System.out.println("Window size: " + windowSize);
            count = Math.min(count, windowSize); 
        }
        System.out.println("Final count: " + count);
        if(count == 0){
            return ""; 
        }   
        else{
            return strings[0].substring(0, count); 
        }
    }
}
