package BinaryTree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RootToLeafPath {
    static class Node{
        int data; 
        Node left; 
        Node right;
        Node(int data){
            this.data = data; 
            this.left = null; 
            this.right = null; 
        }
    }
    public static void main(String[] args) {
        Node root = new Node(10); 
        root.left = new Node(20); 
        root.left.left = new Node(40); 
        root.left.right = new Node(60); 
        root.right = new Node(30); 
        ArrayList<ArrayList<Integer>> path = paths(root); 
        System.out.println(path);
     }
    public static ArrayList<ArrayList<Integer>> paths(Node root){
        // ArrayList<ArrayList<Integer>> path = new ArrayList<>(); 
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(); 
        traverse(list, root, new ArrayList<>()); 
        
        return list;
    }
    private static void traverse(ArrayList<ArrayList<Integer>> list, Node root, ArrayList<Integer> temp){
        if(root == null){
            return; 
        }
        temp.add(root.data);
        if(root.left == null && root.right == null){
            list.add(new ArrayList<>(temp));
        } 
        traverse(list, root.left, temp);
        traverse(list, root.right, temp);
        temp.remove(temp.size()-1); 
    }
}
