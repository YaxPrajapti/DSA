import java.util.Scanner;

public class StoreTestcase {
    public static void main(String[] args) {
        /*
         * 1 2 arr1
         * 1 2 3 arr2
         */
        Scanner sc = new Scanner(System.in);
        String[] arr1 = new String[2]; 
        String[] arr2 = new String[3]; 
        int t = 4;
        for(int i=0;i<arr1.length;i++){
            arr1[i] = sc.next(); 
        }
        for(int i = 0; i < arr2.length; i++){
            arr2[i] = sc.next();
        }
        for(String i : arr1){
            System.out.print(i + " ");
        }
        System.out.println();
        for(String i : arr2){
            System.out.print(i + " ");
        }
        sc.close(); 
    }
}
