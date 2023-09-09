import java.util.Scanner;

public class temp {
    public static void main(String[] args) {
        int[] arr = {3,1,3,4,2}; 
        int find = find(arr); 
        System.out.println(find);
    }
    public static int find(int[] arr){
        int xnor = 0; 
        for(int i : arr){
            xnor = ~(xnor^i); 
        }
        return xnor; 
    }
}
