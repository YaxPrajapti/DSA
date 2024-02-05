import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurances {
    private static final String Map = null;
    public static void main(String[] args) {
        int[] arr = {1,2}; 
        System.out.println(uniqueOccurrences(arr));   
    }
    public static boolean uniqueOccurrences(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                map.replace(arr[i], map.get(arr[i])+1); 
            }else{
                map.put(arr[i], 1); 
            }
        }
        Set<Integer> set = new HashSet<>(); 
        for(Map.Entry<Integer,Integer> mapElement: map.entrySet()){
            Integer val = mapElement.getValue(); 
            if(set.contains(val)){
                return false; 
            }else{
                set.add(val); 
            }
        }
        return true; 
    }
}
