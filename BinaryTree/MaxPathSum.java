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
        TreeNode root = new TreeNode(2); 
        root.left = new TreeNode(-1); 
        int sum = maxpathSum(root); 
        System.out.println(sum);
    }
    public static int maxpathSum(TreeNode root){
        int[] sum = new int[1]; 
        if(root == null){
            return 0; 
        }
        if(root.left==null && root.right==null){
            return root.data; 
        }
        sum[0] = root.data; 
        postOrder(root, sum);
        return sum[0];
    }
    private static int postOrder(TreeNode node, int[] sum){
        if(node == null){
            return 0; 
        }
        int left = postOrder(node.left, sum); 
        int right = postOrder(node.right, sum); 
        sum[0] = Math.max(sum[0], left+right+node.data); 
        return node.data+left + right;  
    }
}
