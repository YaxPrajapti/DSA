package BitManipulation;

public class BinaryToDecimal {
    public static void main(String[] args) {
        String binary = "1000"; 
        int decimal = convertToDecimal(binary); 
        System.out.println(decimal);
    }
    public static int convertToDecimal(String binary){
        char[] arr = binary.toCharArray(); 
        int n = arr.length; 
        int pow = 0; 
        int res = 0; 
        for(int i = n-1; i >= 0; i--){
            char digit = arr[i]; 
            if(digit == '1'){
                res += (1 * Math.pow(2, pow)); 
            }else{  
                res += 0; 
            }
            pow++; 
        }
        return res; 
    }
}
