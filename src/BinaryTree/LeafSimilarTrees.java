package BinaryTree;

import java.util.ArrayList;
import java.util.List;

import BinaryTree.FlattenBinaryTree.TreeNode;

public class LeafSimilarTrees {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3); 
        root.left = new TreeNode(5); 
        root.left.left = new TreeNode(6); 
        root.left.right = new TreeNode(2); 
        root.left.right.left = new TreeNode(7); 
        root.left.right.right = new TreeNode(4); 
        root.right = new TreeNode(1); 
        root.right.left = new TreeNode(9); 
        root.right.right = new TreeNode(8); 
        TreeNode node = new TreeNode(3); 
        node.left = new TreeNode(5); 
        node.left.left = new TreeNode(6); 
        node.left.right = new TreeNode(7); 
        node.right = new TreeNode(1); 
        node.right.left = new TreeNode(4); 
        node.right.right = new TreeNode(2); 
        node.right.right.left = new TreeNode(9); 
        node.right.right.right = new TreeNode(10); 
        boolean res = leafSimilar(root, node); 
        System.out.println(res);
    }
    public static boolean leafSimilar(TreeNode root1, TreeNode root2){
        List<Integer> post1 = new ArrayList<>(); 
        postOrder(root1, post1);
        List<Integer> post2 = new ArrayList<>(); 
        postOrder(root2, post2);
        if(post1.size() != post2.size()){
            return false; 
        }
        int i = 0; 
        int j = 0; 
        while (i < post1.size() && j < post2.size()) {
            if(post1.get(i) != post2.get(j)){
                return false; 
            }
            i++; 
            j++; 
        }
        return true; 
    }
    private static void postOrder(TreeNode root, List<Integer> list){
        if (root == null) {
            return; 
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        if(root.left == null && root.right == null){
            list.add(root.data); 
        }
    }
}
