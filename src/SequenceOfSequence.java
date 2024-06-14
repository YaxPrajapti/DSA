public class SequenceOfSequence {
    public static void main(String[] args) {
        int n = 4; 
        int m = 10; 
        int ans = numberSequence(m, n); 
        System.out.println(ans); 
    }
    public static int numberSequence(int m, int n){ 
        if(n == 0){
            return 1; 
        }
        if(m < n){
            return 0;
        }
        int pick = numberSequence(m/2, n-1); 
        int notpick = numberSequence(m-1, n); 
        return pick+notpick; 
    }

}
