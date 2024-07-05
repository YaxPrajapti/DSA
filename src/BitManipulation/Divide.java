package BitManipulation;

public class Divide {
    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = -1;
        long ans = divide(dividend, divisor);
        System.out.println(ans);
    }

    public static int divide(int dividend, int divisor) {
        boolean sign = true;
        if(dividend==Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        if(dividend == Integer.MIN_VALUE && divisor==1){
            return Integer.MIN_VALUE; 
        }
        if(dividend == divisor){
            return 1; 
        }
        if(dividend == 0) {
            return 0;
        }
        if(dividend < 0 && divisor > 0){
            sign = false; 
        }
        if(dividend > 0 && divisor < 0){
            sign = false; 
        }
        long n = Math.abs((long)dividend); 
        long d = Math.abs((long)divisor); 
        long ans = 0; 
        while(n >= d){
            int count = 0; 
            while((d << (count+1)) <= n){
                count++; 
            }
            ans += (1 << count); 
            n = n - (d << count); 
        }
        if(ans == (1<<31) && sign){
            return Integer.MAX_VALUE; 
        }
        if(ans == (1<<31) && !sign){
            return Integer.MIN_VALUE; 
        }
        return (int)(sign ? ans : -1 * ans); 
    }
}
