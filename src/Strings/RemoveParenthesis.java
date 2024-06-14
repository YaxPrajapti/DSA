package Strings;

public class RemoveParenthesis {
    public static void main(String[] args) {
        String s = "()()"; 
        String ans = removeOuterParentheses(s); 
        System.out.println(ans); 
    }
    public static String removeOuterParentheses(String s){
        int count = 0; 
        StringBuilder ans = new StringBuilder(); 
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i); 
            if(ch == '('){
                if(count == 0){
                    count++; 
                }else if(count > 0){
                    ans.append(ch); 
                    count++; 
                }
            }else{
                count--; 
                if(count == 0){
                    continue; 
                }else if(count > 0){
                    ans.append(ch); 
                }
            }
        }
        return ans.toString(); 
    }
}
