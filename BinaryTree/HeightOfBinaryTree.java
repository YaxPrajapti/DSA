package BinaryTree;

public class HeightOfBinaryTree {
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
        TreeNode root = new TreeNode(3); 
        root.left = new TreeNode(9); 
        root.right = new TreeNode(20); 
        root.right.left = new TreeNode(15); 
        root.right.right = new TreeNode(7); 
        int h = height(root); 
        System.out.println(h);
    }
    public static int height(TreeNode root){
        if(root == null){
            return 0; 
        }
        return 1 + Math.max(height(root.left), height(root.right)); 
    }
}
