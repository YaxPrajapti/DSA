package BinaryTree;

import Arrays.sort2DArray;

public class HeightBalanccedBinaryTree {
    static class TreeNode{
        int data; 
        TreeNode left;  
        TreeNode right;
        TreeNode(int data){
            this.data = data; 
            this.left = null; 
            this.right = null; 
        }
    }
    public static void main(String[] args) {
        // TreeNode root = new TreeNode(3); 
        // root.left = new TreeNode(9); 
        // root.right = new TreeNode(20); 
        // root.right.left = new TreeNode(15); 
        // root.right.right = new TreeNode(7); 
        TreeNode root = new TreeNode(1); 
        root.left = new TreeNode(2); 
        root.left.right = new TreeNode(3); 
        root.left.left = new TreeNode(3); 
        root.left.left.left = new TreeNode(4); 
        root.left.left.right = new TreeNode(4); 
        root.right = new TreeNode(2); 
        boolean isBalanced = isBalanced(root);
        System.out.println(isBalanced);
    }
    public static boolean isBalanced(TreeNode root){
        if(root == null){
            return true; 
        }
        return Math.abs(height(root.left) - height(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right); 
    }
    private static int height(TreeNode node){
        if(node == null){
            return 0; 
        }
        return 1 + Math.max(height(node.left), height(node.right)); 
    }
}
