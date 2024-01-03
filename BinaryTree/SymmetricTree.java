package BinaryTree;

import apple.laf.JRSUIUtils.Tree;

public class SymmetricTree {
    static class TreeNode {
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
        TreeNode root = new TreeNode(1); 
        root.left = new TreeNode(2); 
        root.left.left = new TreeNode(3); 
        root.left.right = new TreeNode(4); 
        root.right = new TreeNode(2); 
        root.right.left = new TreeNode(4); 
        root.right.right = new TreeNode(3); 
        // TreeNode root = new TreeNode(1); 
        // root.left = new TreeNode(2); 
        // root.left.right = new TreeNode(3); 
        // root.right = new TreeNode(2); 
        // root.right.right = new TreeNode(3); 
        boolean ans = isSymmetric(root); 
        System.out.println(ans);
    }
    public static boolean isSymmetric(TreeNode root){
        if(root == null){
            return true; 
        }
        TreeNode left = root; 
        TreeNode right = root;
        if(root.left != null && root.right != null){
            left = root.left; 
            right = root.right; 
        }
        return traverse(root.left, root.right); 
    }
    private static boolean traverse(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true; 
        }

        if((left == null && right != null) || (right == null && left != null)){
            return false; 
        }
        
        if(left.data != right.data){
            return false;
        }
     
        return traverse(left.left, right.right) && traverse(left.right, right.left); 
    }

}
