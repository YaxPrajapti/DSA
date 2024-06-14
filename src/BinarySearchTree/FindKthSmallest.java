package BinarySearchTree;

import java.util.ArrayList;

import Arrays.sort2DArray;
import BinarySearchTree.DeleteNode.TreeNode;

public class FindKthSmallest {
    public static void main(String[] args) {
        // TreeNode root = new TreeNode(3);
        // root.left = new TreeNode(1);
        // root.left.right = new TreeNode(2);
        // root.right = new TreeNode(4);
        // TreeNode root = new TreeNode(5);
        // root.left = new TreeNode(3);
        // root.left.left = new TreeNode(2);
        // root.left.left.left = new TreeNode(1);
        // root.left.right = new TreeNode(4);
        // root.right = new TreeNode(6);
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        int ans = kthSmallest(root, 1);
        System.out.println(ans);
    }

    public static int kthSmallest(TreeNode root, int k) {
        // in BST left subtree is having less values than root and right subtree
        // left < node < right
        // If we do inorder traversal then we will have the sorted order of binary tree.
        // then we can return the k-1(index) element;
        /*
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(list, root);
        return list.get(k - 1);
         */
        // optimal approach will be:
        /*
         * We need the kth smallest element. And, we know that our inorder traversal
         * will first give the 1st smallest element, then 2nd smallest element ... and
         * so on.
         * So, instead of storing the node values inside a vector, we can maintain a
         * 'cnt' variable to keep track if we have reached kth smallest value or not in
         * the inorder traversal. And then, we can return the value once cnt reaches k
         * value.
         */
        int[] ans = {0};
        int[] count = {0}; 
        inOrder(root, k, ans, count);
        return ans[0]; 
    }

    private static void inOrder( TreeNode root, int k, int[] ans, int[] count) {
        if (root == null) {
            return;
        }
        inOrder(root.left, k, ans, count);
        count[0]++; 
        if(count[0] == k){
            ans[0] = root.data; 
            return; 
        }
        inOrder(root.right, k, ans, count);
    }

}
