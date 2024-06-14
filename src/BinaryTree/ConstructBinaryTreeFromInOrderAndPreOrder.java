package BinaryTree;

import java.util.HashMap;

public class ConstructBinaryTreeFromInOrderAndPreOrder {
    static class Node {
        int data; 
        Node left; 
        Node right; 
        Node(int data){
            this.left = null; 
            this.right = null; 
            this.data = data; 
        }
        
    }
    public static void main(String[] args) {
        int[] inOrder = {9,3,15,20,7};
        int[] preOrder = {3,9,20,15,7};

    }
    public static Node buildTree(int[] preOrder, int[] inOrder){
        HashMap<Integer, Integer> map = new HashMap<>(); 
        for(int i = 0; i < inOrder.length; i++){
            map.put(inOrder[i], i); 
        }
        int in_start = 0; 
        int in_end = inOrder.length-1; 
        int pre_start = 0; 
        int pre_end = preOrder.length - 1; 
        Node root = build(preOrder, pre_start, pre_end, inOrder, in_start, in_end, map); 
        return root; 
    }
    private static Node build(int[] preOrder, int pre_start, int pre_end, int[] inOrder, int in_start, int in_end, HashMap<Integer, Integer> map){
        if(pre_start > pre_end || in_start > in_end){
            return null; 
        }
        Node root = new Node(preOrder[pre_start]); 
        int inRoot = map.get(root.data); 
        int numLeft = inRoot - in_start; 
        root.left = build(preOrder, pre_start+1, pre_start+numLeft, inOrder, in_start, inRoot-1, map); 
        root.right = build(preOrder, pre_start+numLeft+1, pre_end, inOrder, inRoot+1, in_end, map); 
        return root; 
    }
}
