package BitManipulation; 
public class ConvertIntToBit {

    public static void main(String[] args) {
        int integer = 13; 
        String bitString = convertToBit(integer); 
        System.out.println(bitString);
    }
    public static String convertToBit(int integer){
        StringBuilder rem = new StringBuilder(); 
        while (integer != 1) {
            if((integer&1) == 1){
                rem.append("1"); 
            }else {
                rem.append("0"); 
            }
            integer = integer/2; 
        }
        rem.append(integer); 
        return rem.reverse().toString(); 
    }
}