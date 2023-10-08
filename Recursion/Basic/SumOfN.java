package Recursion.Basic;

public class SumOfN {
    public static void main(String[] args) {
        int N = 10; 
        int sum = 0; 
        sum = sum(1, N, sum); 
        System.out.println(sum);
        int sumII = sumII(N, 0);
        System.out.println(sumII);
    }
    public static int sum(int start, int N, int sum){
        if(start > N){
            return sum; 
        } 
        sum+=start; 
        return sum(start+1, N, sum); 
    }
    public static int sumII(int num, int sum){
        if(num < 1){
            return sum; 
        }
        sum += num; 
        return sumII(num-1, sum); 
    }
}
