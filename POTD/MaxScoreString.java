package POTD;

public class MaxScoreString {
    public static void main(String[] args) {
        String s = "011101"; 
        int score = maxScore(s); 
        System.out.println(score);
    }
    public static int maxScore(String s){
        String left = ""; 
        String right= ""; 
        int max_score = 0; 
        for(int i = 1; i < s.length(); i++){
            String temp = s; 
            left = temp.substring(0, i); 
            right = temp.substring(i, s.length()); 
            max_score = Math.max(max_score, calculateScore(left, right));
        }
    
        return max_score; 
    }
    private static int calculateScore(String lefString, String rightString){
        int leftScore = 0; 
        int rightScore = 0; 
        //left score 
        for(int i = 0; i < lefString.length(); i++){
            if(lefString.charAt(i) == '0'){
                leftScore++; 
            }
        }
        //right score
        for(int i = 0; i < rightString.length(); i++){
            if(rightString.charAt(i) == '1'){
                rightScore++; 
            }
        }
        return leftScore+rightScore;    
    }
}
