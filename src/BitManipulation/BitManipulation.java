package BitManipulation;

public class BitManipulation {
    public static void main(String[] args) {
        int num = 12; 
        int i = 3; 
        bitManipulation(num, i);
    }
    static void bitManipulation(int num, int i) {
        int get = (num >> (i-1)) & 1; 
        int set = num | (1 << i-1); 
        int clear = num & ~(1 << i-1); 
        int toggle = num ^ (1 << i-1); 
        int removeLastSetBit = num & (num-1); 
        boolean powerOftwo = ((num & (num - 1)) == 0) ? true : false;
        int numberOfSetBits = countNumberOfSetBits(num);
        System.out.println(get + "   " + set + "   " + clear + "   " + toggle + "   " + removeLastSetBit + "   " + powerOftwo + "   " + numberOfSetBits);
    }
    public static int countNumberOfSetBits(int num){
        int count = 0; 
        while (num != 1) {
            if((num & 1) == 1){
                count++; 
            }
            num = (num >> 1); 
        }
        if(num == 1){
            count++; 
        }
        return count; 

    }
}
