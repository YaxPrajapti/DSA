package BinaryTree;

import java.util.ArrayList;

import Arrays.sort2DArray;

public class SumOfRootToLeaf {
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
        root.left = new TreeNode(9); 
        root.left.left = new TreeNode(5); 
        root.left.right = new TreeNode(1); 
        root.right = new TreeNode(0); 
        int sumNumbers = sumNumbers(root); 
        System.out.println(sumNumbers);
    }
    public static int sumNumbers(TreeNode root){
        ArrayList<String> list = new ArrayList<>(); 
        StringBuilder sb = new StringBuilder(); 
        traverse(list, sb, root); 
        int sum = 0; 
        for(String s : list){
            sum = sum + Integer.parseInt(s); 
        }
        return sum; 
    }
    private static void traverse(ArrayList<String> list, StringBuilder sb, TreeNode root){
        if(root == null){
            return; 
        }
        
        sb.append(root.data); 
        if(root.left == null && root.right == null){
            list.add(new String(sb.toString())); 
        }
        traverse(list, sb, root.left); 
        traverse(list, sb, root.right);
        sb.deleteCharAt(sb.length()-1); 
    }


}
