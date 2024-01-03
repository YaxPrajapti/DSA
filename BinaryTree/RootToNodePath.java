package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
* Node
 */
class Node {
    int data; 
    Node left; 
    Node right; 
    Node(int data){
        this.data = data; 
        this.left = null; 
        this.right = null; 
    }
}
public class RootToNodePath {
    public static void main(String[] args) {
        Node root = new Node(1); 
        root.left = new Node(2); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.left.right.left = new Node(6); 
        root.left.right.right = new Node(7); 
        root.right = new Node(3); 
        List<Integer> list = getPath(root, 7);
        System.out.println(list); 
    }
    public static List<Integer> getPath(Node root, int x){
        List<Integer> path = new ArrayList<>(); 
        traverse(root, x, path);
        return path; 
    }
    private static boolean traverse(Node root, int x, List<Integer> path){
        if(root == null){
            return false; 
        }
        path.add(root.data); 
        if(root.data == x){
            return true; 
        }
        if(traverse(root.left, x, path) || traverse(root.right, x, path)){
            return true; 
        }
        path.remove(path.size()-1); 
        return false; 
    }
}
