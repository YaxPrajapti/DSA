import java.util.ArrayList;

import java.util.List;

public class BuiltAnArrayWithStackOperation {
    public static void main(String[] args) {
        int n = 3;
        int[] target = { 1, 3 };
        List<String> ans = buildArray(target, n);
        System.out.println(ans);
    }

    public static List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int index = 0;
        int i = 1;
        while (index < target.length && i <= n) {
            int num = target[index]; 
            if(i == num){
                ans.add("Push"); 
                index++; 
                i++; 
            }else{
                ans.add("Push");
                ans.add("Pop");
                i++; 
            }
        }
        return ans; 
    }
}
