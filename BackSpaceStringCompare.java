import Arrays.sort2DArray;

public class BackSpaceStringCompare {
    public static void main(String[] args) {
        String s = "ab#c"; 
        String t = "ad#c"; 
        backspaceCompare(s, t); 
    }
    public static boolean backspaceCompare(String s, String t){
        String s1 = processString(s); 
        String s2 = processString(t); 
        if(s1.compareTo(s2) == 0){
            return true; 
        }
        return false; 
    }
    private static String processString(String s){
        StringBuilder st = new StringBuilder(); 
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i); 
            if(ch == '#'){
                if(i == 0 || st.length()==0){
                    continue; 
                }else{
                    st.deleteCharAt(st.length()-1);
                } 
            }else{
                st.append(ch); 
            }
        }
        return st.toString(); 
    }
    
}
