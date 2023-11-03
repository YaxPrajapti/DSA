package BinaryTree;

public class CountNodesEqualToAvgOfSubTree {
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
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8); 
        root.right = new TreeNode(5); 
        root.left.left = new TreeNode(0); 
        root.left.right = new TreeNode(1); 
        root.right.right = new TreeNode(6); 
        int avg = averageOfSubtree(root); 
        System.out.println(avg);
    }
    static int count; 
    public static int averageOfSubtree(TreeNode root){
        if(root == null){
            return 0; 
        }
        postOrder(root); 
        return count; 
    }
    private static int[] postOrder(TreeNode root){
        if(root == null){
            return new int[]{0,0}; 
        }
        int[] left = postOrder(root.left); 
        int[] right = postOrder(root.right); 
        int sum = left[0] + right[0] + root.data; 
        int n = left[1] + right[1] + 1; 
        int avg = sum / n; 
        if(avg == root.data){
            count++; 
        }
        return new int[]{sum, n}; 
    }
    
}
