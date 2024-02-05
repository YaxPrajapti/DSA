package Strings;

public class Reverse {
    public static void main(String[] args) {
        String s = "Example";
        StringBuilder st = new StringBuilder(s);  
        reverse(st, 0, st.length()-1);
        System.out.println(st);
    }
    private static void reverse(StringBuilder st, int start, int end){
        while(start <= end){
            char temp = st.charAt(start); 
            st.replace(start, start+1, Character.toString(st.charAt(end))); 
            st.replace(end, end+1, Character.toString(temp));   
            start++; 
            end--; 
        }
    }
}
