package Recursion.Basic;

public class PrintInReverse {
    public static void main(String[] args) {
        int start = 10; 
        print(start); 
    }
    public static void print(int start){
        if(start < 1){
            return; 
        }
        print(start-1);
        System.out.println(start);
         
    }
}

