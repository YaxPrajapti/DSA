package Strings;

public class FirstUniqueChar {
    public static void main(String[] args) {
        String s = "aabb";
        int index = firstUni(s);
        System.out.println("index = " + index);
    }
    public static int firstUni(String s){
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            boolean flag = false;
            for(int j = i+1; j < s.length(); j++){
                char ch2 = s.charAt(j);
                if(ch2 == ch){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                return i; 
            }
        }
        return -1; 
    }
}
