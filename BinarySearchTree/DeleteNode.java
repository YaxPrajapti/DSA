package BinarySearchTree;

import javax.swing.tree.TreeNode;

public class DeleteNode {
    static class TreeNode{
        TreeNode left; 
        TreeNode right; 
        int data; 
        TreeNode(int data){
            this.data = data; 
            this.left = null; 
            this.right = null; 
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5); 
        root.left = new TreeNode(3); 
        root.left.left = new TreeNode(2); 
        root.left.right = new TreeNode(4); 
        root.right = new TreeNode(6); 
        root.right.right = new TreeNode(7); 
        printTree(root); 
        deleteNode(root, 3); 
        System.out.println();
        printTree(root);
    }
    private static void printTree(TreeNode root){
        if(root == null){
            return; 
        }
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }
    public static TreeNode deleteNode(TreeNode root, int key){
        if(root == null){
            return root; 
        }
        if(root.data == key){
            if(root.left == null){
                return root.right; 
            }
            if(root.right == null){
                return root.left; 
            }
            TreeNode temp = root.left; 
            while (temp.right != null) {
                temp = temp.right; 
            }
            temp.right = root.right; 
            return root.left; 
        }
        if(key < root.data){
            root.left = deleteNode(root.left, key); 
        }
        if(key > root.data){
            root.right = deleteNode(root.right, key); 
        }
        return root; 
    }
}
