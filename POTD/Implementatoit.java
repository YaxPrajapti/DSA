package POTD;

public class Implementatoit {
    public static void main(String[] args) {
        String s = "325-";
        int num = atoi(s);
        System.out.println("num = " + num);
    }
    public static int atoi(String s){
        int i = 0;
        if(s.charAt(0) == '-'){
            i = 1;
        }
        for(i = i; i < s.length(); i++){
            char ch = s.charAt(i);
            if((int)ch-48 > 9 || (int)ch-48 < 0){
                return -1;
            }
        }
        return Integer.parseInt(s);
    }
}
