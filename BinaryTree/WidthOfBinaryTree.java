package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBinaryTree {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode rigth;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.rigth = null;
        }
    }

    static class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int num) {
            this.index = num;
            this.node = node;
        }
    }

    public static void main(String[] args) {

    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int ans = 0;
        while (!q.isEmpty()) {
            int min = q.peek().index;
            int size = q.size();
            int first = 0;
            int last = 0;
            for (int i = 0; i < size; i++) {
                int curr_index = q.peek().index - min;
                TreeNode node = q.peek().node;
                q.poll();
                if (i == 0) {
                    first = curr_index;
                }
                if (i == size - 1) {
                    last = curr_index;
                }
                if (node.left != null) {
                    q.add(new Pair(node.left, curr_index * 2 + 1));
                }
                if (node.right != null) {
                    q.add(new Pair(node.right, curr_index * 2 + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}
