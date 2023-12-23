package BinaryTree;


public class DiameterOfBinaryTree {
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2); 
        root.left.right = new TreeNode(5); 
        root.left.left = new TreeNode(4); 
        root.right = new TreeNode(3); 
        int diameterOfTree = diameterOfTree(root); 
        System.out.println(diameterOfTree);
    }
    
    public static int diameterOfTree(TreeNode root){
        //traverse the tree 
        //check for the left and right subtree height 
        //take the curr node as the curving node if left and right height of subtree is maximum amongst all 
        //return the height of left subtree + height of right subtree 
        int[] length = new int[1]; 
        if(root == null){
            return 0; 
        }   
        height(root, length); 
        return length[0]; 
    }
    private static int height(TreeNode root, int[] length){
        if(root == null){
            return 0; 
        }
        int left  = height(root.left, length);
        int right = height(root.right, length);
        length[0] = Math.max(length[0], left+right); 
        return Math.max(left, right) + 1; 
    }
}
