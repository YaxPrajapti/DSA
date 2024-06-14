package Recursion.SubSequences;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStrings {
    public static void main(String[] args) {
        int N = 3; 
        List<String> ans = generateBinaryStrings(N); 
        System.out.println(ans);
    }
    public static List<String> generateBinaryStrings(int N){
        int index = 0; 
        List<String> ans = new ArrayList<>();  
        generate(index, N, ans, new StringBuilder()); 
        return ans; 
    }
    public static void generate(int index, int N, List<String> ans, StringBuilder st){
        //base case
        if(index == N){
            ans.add(st.toString()); 
            return; 
        }
        //chose to put 0
        st.append('0'); 
        generate(index+1, N, ans, st);
        st.deleteCharAt(st.length()-1); 
        if(index == 0 || (index > 0 && st.charAt(index-1) != '1')){
            st.append('1');
            generate(index+1, N, ans, st);
            st.deleteCharAt(st.length()-1); 
        } 
    }
}
