package POTD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentiallyDigits {
    public static void main(String[] args) {
        int low = 58;
        int high = 155;
        List<Integer> list = sequentialDigits(low, high);
        System.out.println("list = " + list);
    }
    public static List<Integer> sequentialDigits(int low, int high){
        List<Integer> list = new ArrayList<>();
        char[] lowerBound = String.valueOf(low).toCharArray();
        for(int i = 1; i <= 9; i++){
            int num = i;
            int nextDigit = i + 1;
            while (num <= high && nextDigit <= 9){
                num = num * 10 + nextDigit;
                //this will make sure ki number will be added in the list if it is > the lower bound
                if(num >= low && num <= high){
                    list.add(num);
                }
                if(num > high){
                    break;
                }
                nextDigit++;
            }
        }
        Collections.sort(list);
        return list;

    }
}


