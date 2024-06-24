package SlidingWindow;

/**
 * LongestRepWithoutReplacemnt
 */
public class LongestRepWithoutReplacemnt {

    public static void main(String[] args) {
        String s = "ABAB"; 
        int k = 2; 
        int characterReplacement = characterReplacement(s, k); 
        System.out.println(characterReplacement);
    }

    public static int characterReplacement(String s, int k) {
        int i =0; 
        int j = 0; 
        char[] arr = s.toCharArray(); 
        int n = arr.length; 
        int[] map = new int[26]; 
        int len = 0; 
        while(j < n){
            char ch = arr[j]; 
            map[ch - 'A']++;  
            while((j-i+1) - maxCount(map) > k && i <= j){
                System.out.println(arr[i]-'A'); 
                map[arr[i]-'A']--; 
                i++; 
            }
            len = Math.max(len, j-i+1); 
            j++; 
        }
        return len; 
    }
    private static int maxCount(int[] map){
        int n = map.length; 
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            maxi = Math.max(maxi, map[i]); 
        }
        return maxi; 
    }
}