package Arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        int numRows = 30; 
        ArrayList<ArrayList<Integer>> pascal = pascaltri(numRows); 
        System.out.println(pascal);
        List<Integer> getRow = getRow(30); 
        System.out.println();
        System.out.println(getRow);
    }
    public static ArrayList<ArrayList<Integer>> pascaltri(int numRows){
        ArrayList<ArrayList<Integer>> pascal = new ArrayList<>(numRows); 
        for(int i = 0; i < numRows; i++){
            pascal.add(new ArrayList<>(i+1));  
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    pascal.get(i).add(j, 1); 
                }else{
                    pascal.get(i).add(j, pascal.get(i-1).get(j-1) + pascal.get(i-1).get(j)); 
                }
            }
        }
        return pascal;
    }
    public static List<Integer> getRow(int rowIndex){
        List<Integer> ans = new ArrayList<>(); 
        long prev = 1; 
        ans.add((int)prev); 
        int row = rowIndex+1; 
        for(int i = 1; i < row; i++){
            prev = prev * (row - i); 
            prev = prev / i; 
            ans.add((int)prev); 
        }
        return ans; 
    }
}
