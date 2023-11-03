public class FindTheOriginalArrOfXor {
    public static void main(String[] args) {
        int[] pref = {5,2,0,3,1}; 
        // int[] pref = {13}; 
        int[] ans = findArray(pref); 
        for(int i : ans){
            System.out.print(i + " ");
        }
        // System.out.println(5^2);
    }
    public static int[] findArray(int[] pref){
        int[] ans = new int[pref.length]; 
        int prevxor = 0; 
        for(int i = 0; i < pref.length; i++){
            ans[i] = prevxor ^ pref[i]; 
            prevxor = prevxor ^ ans[i]; 
        }
        return ans; 
    }
}
