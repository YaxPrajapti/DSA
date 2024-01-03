package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrderTraversal {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> zigzagLevelOrder = zigzagLevelOrder(root);
        System.out.println(zigzagLevelOrder);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean leftToRight = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int levelNum = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = q.peek();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                node = q.poll();
                if (leftToRight) {
                    temp.add(node.data);
                }
                else{
                    temp.add(0, node.data);
                }
            }
            list.add(temp);
            leftToRight = !leftToRight;
            
        }
        return list;
    }
}
