package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge {
    class DisJointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisJointSet(int n) {
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

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        List<List<String>> ans = new ArrayList<>();
        DisJointSet ds = new DisJointSet(n);
        HashMap<String, Integer> mailToNode = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int m = accounts.get(i).size();
            for (int j = 1; j < m; j++) {
                String mail = accounts.get(i).get(j);
                if (mailToNode.containsKey(mail)) {
                    ds.unionBySize(i, mailToNode.get(mail));
                } else {
                    mailToNode.put(mail, i);
                }

            }
        }
        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            mergedMail[i] = new ArrayList<>();
        }
        for (Map.Entry<String, Integer> entry : mailToNode.entrySet()) {
            String mail = entry.getKey();
            int node = ds.findUltimateParent(entry.getValue());
            mergedMail[node].add(mail);
        }

        for (int i = 0; i < n; i++) {
            if (mergedMail[i].size() == 0)
                continue;
            String owner = accounts.get(i).get(0);
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(owner);
            temp.addAll(mergedMail[i]);
            ans.add(temp);
        }

        return ans;
    }
}
