package Arrays;

import java.util.ArrayList;

public class RearrangeElements {

    public static void main(String[] args) {
        int[] arr =  {-1, 2, -3, 4, -5, 6};
        // int[] ans = rearrangeElements(arr);
        int[] ans = rearrangeElements2(arr);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
    //when number of positive and negative numbers are not same. 
    public static int[] rearrangeElements2(int[] arr){
        ArrayList<Integer> pos = new ArrayList<>(); 
        ArrayList<Integer> neg = new ArrayList<>(); 
        //seggregate pos and neg numbers into different lists. 
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0){
                neg.add(arr[i]); 
            }else{
                pos.add(arr[i]); 
            }
        }
        //set the elements of smaller list; 
        if(pos.size() < neg.size()){
            for(int i = 0; i < pos.size(); i++){
                arr[2*i] = pos.get(i); 
                arr[2*i + 1] = neg.get(i); 
            }
            int index = pos.size()*2; 
            for(int i = pos.size(); i < neg.size(); i++){
                arr[index] = neg.get(i); 
                index++; 
            }
        }if(neg.size() < pos.size()){
            for(int i = 0; i < neg.size(); i++){
                arr[2*i] = pos.get(i); 
                arr[2*i + 1] = neg.get(i); 
            }
            int index = neg.size()*2; 
            for(int i = neg.size(); i < pos.size(); i++){
                arr[index] = pos.get(i); 
                index++; 
            }
        }
        return arr; 
    }

    //When number positive and negative elements are same. 
    public static int[] rearrangeElements(int[] arr) {
        int positiveIndex = 0; 
        int negativeIndex = 1; 
        int[] ans = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 0){
                ans[positiveIndex] = arr[i]; 
                positiveIndex = positiveIndex+2; 
            }
            if(arr[i] < 0){
                ans[negativeIndex] = arr[i]; 
                negativeIndex = negativeIndex + 2; 
            }
        }
        return ans; 
    }
}
