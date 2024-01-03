package BinaryTree;

public class MaxPathSum {
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
        // TreeNode root = new TreeNode(1); 
        // root.left = new TreeNode(2); 
        // root.right = new TreeNode(3); 
        // TreeNode root = new TreeNode(-10); 
        // root.left = new TreeNode(9); 
        // root.right = new TreeNode(20); 
        // root.right.left = new TreeNode(15); 
        // root.right.right = new TreeNode(7); 
        // TreeNode root = new TreeNode(2); 
        // root.left = new TreeNode(-1); 
        TreeNode root = new TreeNode(1); 
        root.left = new TreeNode(2); 
        root.right = new TreeNode(3); 
        int sum = maxpathSum(root); 
        System.out.println(sum);
    }
    public static int maxpathSum(TreeNode root){
        int[] sum = {Integer.MIN_VALUE}; 
        findSum(root, sum);     
        return sum[0]; 
    }
    private static int findSum(TreeNode root, int[] sum){
        if(root == null){
            return 0; 
        } 
        int leftSum = Math.max(findSum(root.left, sum), 0); 
        int rightSum = Math.max(findSum(root.right, sum), 0); 
        sum[0] = Math.max(sum[0], leftSum+rightSum+root.data);
        return root.data + Math.max(leftSum, rightSum);
    }
    
    
}
