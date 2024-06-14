package BinaryTree;

public class MaxDiffBetweenNodeAndAncestor {
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
        TreeNode root = new TreeNode(8); 
        root.left = new TreeNode(3); 
        root.left.left = new TreeNode(1); 
        root.left.right = new TreeNode(6); 
        root.left.right.left = new TreeNode(4); 
        root.left.right.right = new TreeNode(7); 
        root.right = new TreeNode(10); 
        root.right.right = new TreeNode(14); 
        root.right.right.left = new TreeNode(13); 
        int diff = maxAncestorDiff(root); 
        System.out.println(diff);
    }
    public static int maxAncestorDiff(TreeNode root){
            int[] maxi = {0}; 
            helper(root, maxi); 
            return maxi[0];
        }
    public static int[] helper(TreeNode root, int[] maxi){
        if(root == null){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        int[] left = helper(root.left, maxi); 
        int[] right = helper(root.right, maxi); 
        int curr_min = Math.min(root.data, Math.min(left[0], right[0])); 
        int curr_max = Math.max(root.data, Math.max(left[1], right[1])); 
        maxi[0] = Math.max(maxi[0], Math.max(Math.abs(root.data - curr_min), Math.abs(root.data - curr_max))); 
        return new int[]{curr_min, curr_max}; 
    }
}
