package POTD;

import java.util.*;

public class SortCharactersByFreq {
    public static void main(String[] args) {
        String s = "tree";
        String sortedString = frequencySort(s);
        System.out.println("sortedString = " + sortedString);
    }
    public static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(Character ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        System.out.println(map);
        TreeMap<Integer, List<Character>> sortedMap = new TreeMap<>();
        for(Map.Entry<Character, Integer> element : map.entrySet()){
            char key = element.getKey();
            int freq = element.getValue();
            if(sortedMap.containsKey(freq)){
                sortedMap.get(freq).add(key);
            }else {
                sortedMap.put(freq, new ArrayList<>());
                sortedMap.get(freq).add(key);
            }
        }
        System.out.println(sortedMap);
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, List<Character>> element: sortedMap.entrySet()){
            List<Character> list = element.getValue();
            int freq = element.getKey();
            System.out.println(list);
            for (Character character : list) {
                sb.append(String.valueOf(character).repeat(Math.max(0, freq)));
            }
        }
        return sb.reverse().toString();
    }
}
