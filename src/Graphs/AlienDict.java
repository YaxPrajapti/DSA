package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDict {
    public static void main(String[] args) {
        int N = 3;
        int K = 3;
        String[] dict = { "caa", "aaa", "aab" };
        String ans = findOrder(dict, N, K);
        System.out.println(ans);
    }

    public static String findOrder(String[] dict, int N, int K) {
        ArrayList<ArrayList<Character>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }
        buildgraph(dict, N, adj, K);
        int[] indegree = new int[K];
        for (int i = 0; i < K; i++) {
            for (Character node : adj.get(i)) {
                indegree[node - 'a']++;
            }
        }
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            if (indegree[i] == 0) {
                q.add((char) (i + 'a'));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char node = q.poll();
            sb.append(node);
            for (Character nei : adj.get(node - 'a')) {
                indegree[nei - 'a']--;
                if (indegree[nei - 'a'] == 0) {
                    q.add(nei);
                }
            }
        }
        return sb.toString();
    }

    public static void buildgraph(String[] dict, int N, ArrayList<ArrayList<Character>> adj, int K) {
        for (int i = 0; i < N - 1; i++) {
            String s = dict[i];
            String t = dict[i + 1];
            int index = findDifferentChar(s, t);
            if (index != -1) {
                adj.get(s.charAt(index) - 'a').add(t.charAt(index));
            }
        }
    }

    private static int findDifferentChar(String s, String t) {
        int len = Math.min(s.length(), t.length());
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return i;
            }
        }
        return -1;
    }
}
