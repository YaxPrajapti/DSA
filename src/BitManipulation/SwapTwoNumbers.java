package BitManipulation;

public class SwapTwoNumbers {
    public static void main(String[] args) {
        int a = 5; 
        int b = 7; 
        int[] swapped = swap(a, b); 
        System.out.println(swapped[0] + "   " + swapped[1]);
    }
    public static int[] swap(int a, int b){
        a = a ^ b; 
        b = a ^ b; 
        a = a ^ b; 
        return new int[]{a,b}; 
    }
}
