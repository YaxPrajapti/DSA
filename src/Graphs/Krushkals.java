package Graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Krushkals {
    /**
     * Edge
     */
    static class Edge {

        int src;
        int target;
        int wt;

        Edge(int src, int target, int wt) {
            this.src = src;
            this.target = target;
            this.wt = wt;
        }
    }

    static class InnerDisJointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public InnerDisJointSet(int n) {
            for (int i = 0; i <= n; i++) {
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }

        public int findUltimateParent(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int ultimateParent = findUltimateParent(parent.get(node));
            parent.set(node, ultimateParent);
            return parent.get(node);
        }

        public void unionBySize(int u, int v) {
            int ulp_u = findUltimateParent(u);
            int ulp_v = findUltimateParent(v);
            if (ulp_u == ulp_v) {
                return;
            }
            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));
            }
        }

        public void unionByRank(int u, int v) {
            int ulp_u = findUltimateParent(u);
            int ulp_v = findUltimateParent(v);
            if (ulp_u == ulp_v) {
                return;
            }
            if (rank.get(ulp_u) < rank.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
            } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
                parent.set(ulp_v, ulp_u);
            } else {
                parent.set(ulp_u, ulp_v);
                rank.set(ulp_u, rank.get(ulp_u) + 1);
            }
        }
    }

    public static void main(String[] args) {

    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // build the edges.
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            for (int[] arr : adj.get(i)) {
                int src = i;
                int target = arr[0];
                int wt = arr[1];
                edges.add(new Edge(src, target, wt));
            }
        }
        Collections.sort(edges, (Edge e1, Edge e2) -> e1.wt - e2.wt);
        InnerDisJointSet ds = new InnerDisJointSet(V); 
        int maxi = 0; 
        for(Edge edge : edges){
            int src = edge.src; 
            int target = edge.target; 
            int wt = edge.wt; 
            if(ds.findUltimateParent(src) != ds.findUltimateParent(target)){
                ds.unionBySize(src, target);
                maxi+=wt; 
            }
        }
        return maxi; 
    }
}
