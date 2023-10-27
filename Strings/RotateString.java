package Strings;

public class RotateString {
    public static void main(String[] args) {
        String s = "bbbacddceeb"; 
        String goal = "ceebbbbacdd"; 
        boolean res = rotateString(s, goal); 
        System.out.println(res);
    }
    public static boolean rotateString(String s, String goal){
        StringBuilder st = new StringBuilder(s); 
        for(int i = 0; i < s.length(); i++){
            char ch = st.charAt(0); 
            st.deleteCharAt(0); 
            st.append(ch); 
            if(st.toString().equals(goal)){
                return true; 
            }
        }
        return false; 
    }
}
