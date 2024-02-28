package POTD;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
//        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        String[] strs = {"a"};
        List<List<String>> ans = groupAnagrams(strs);
        System.out.println(ans);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sordedStirng = new String(chars);
            if(!map.containsKey(sordedStirng)){
                map.put(sordedStirng, new ArrayList<String>());
            }
            map.get(sordedStirng).add(s);
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> mapelement : map.entrySet()){
            String key = mapelement.getKey();
            List<String> group =mapelement.getValue();
            ans.add(group);
        }
        return ans;
    }
}
