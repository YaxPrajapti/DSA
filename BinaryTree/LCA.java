package BinaryTree;

public class LCA {
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
        root.left.left = new TreeNode(4); 
        root.left.right = new TreeNode(5); 
        root.left.right.left = new TreeNode(6); 
        root.left.right.right = new TreeNode(7); 
        root.right = new TreeNode(3); 
        root.right.left = new TreeNode(8); 
        root.right.right = new TreeNode(9); 
        TreeNode p = root.left.left; 
        TreeNode q = root.left.right.right; 
        TreeNode lowestCommonAncestor = lowestCommonAncestor(root, p, q); 
        System.out.println(lowestCommonAncestor);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q){
            return root; 
        }    
        TreeNode left = lowestCommonAncestor(root.left, p, q); 
        TreeNode right = lowestCommonAncestor(root.right, p, q); 
        if(left == null){
            return right; 
        }
        if(right == null){
            return right; 
        }
        else{
            return root; 
        }
    }
    
}
