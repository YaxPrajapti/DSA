package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import javax.management.Query;

/**
 * WordLadder:
 * Solution 1:
 * we will create a map which stores the neighbors for each word. neighbor =
 * having difference of 1 char.
 * this adj list. and then perform bfs. the level of the final
 * node would be the ans.
 */
public class WordLadder {
    static class Pair {
    
        String s; 
        int level; 
        Pair(String s, int level){
            this.s = s; 
            this.level = level; 
        }
    }
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log", "cog"));
        int length = ladderLength(beginWord, endWord, wordList);
        System.out.println(length);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        int n = wordList.size();
        for (int i = 0; i < n; i++) {
            if (diff(wordList.get(i), beginWord) == 1) {
                map.putIfAbsent(beginWord, new ArrayList<>());
                ArrayList<String> neighbour = map.get(beginWord);
                neighbour.add(wordList.get(i));
                map.put(beginWord, neighbour);
            }
        }
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(wordList.get(i), new ArrayList<>());
            for (int j = i + 1; j < n; j++) {
                if (diff(wordList.get(i), wordList.get(j)) == 1) {
                    ArrayList<String> neighbour = map.get(wordList.get(i));
                    neighbour.add(wordList.get(j));
                    map.put(wordList.get(i), neighbour);
                }
            }
        }
        Set<String> visited = new HashSet(); 
        Queue<Pair> q = new LinkedList<>(); 
        visited.add(beginWord); 
        q.add(new Pair(beginWord, 1)); 
        while(!q.isEmpty()){
            Pair p = q.poll(); 
            if(p.s == endWord){
                return p.level; 
            }
            ArrayList<String> neighbour = map.get(p.s); 
            for(String s : neighbour){
                if(!visited.contains(s)){
                    q.add(new Pair(s, p.level+1)); 
                    visited.add(s); 
                }
            }
        }
        return 0; 
    }
    private static int diff(String s, String t){
        int count = 0; 
        int n = s.length(); 
        for(int i = 0; i < n; i++){
            if(s.charAt(i) != t.charAt(i)){
                count++; 
            }
        }
        return count; 
    }
}