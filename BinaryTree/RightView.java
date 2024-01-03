package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class RightView {
    static class Pair{
        int level; 
        Node node; 
        Pair(int level, Node node){
            this.level = level; 
            this.node = node; 
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2); 
        root.left.right = new Node(5);
        root.right = new Node(3); 
        root.right.right = new Node(4); 
        // List<Integer> list  = rightSideView(root); 
        List<Integer> list = rightSide(root); 
        System.out.println(list);
    }
    public static List<Integer> rightSide(Node root){
        List<Integer> list = new ArrayList<>(); 
        //root -> right -> left. 
        traverse(root, list, 0); 
        return list; 
    }
    private static void traverse(Node root, List<Integer> list, int level){
        if(root == null){
            return; 
        }
        if(level == list.size()){
            list.add(root.data); 
        }
        traverse(root.right, list, level+1); 
        traverse(root.left, list,level+1);
    }
    public static List<Integer> rightSideView(Node root){
        ArrayList<Integer> list = new ArrayList<>(); 
        TreeMap<Integer, Integer> map = new TreeMap<>(); 
        Queue<Pair> q = new LinkedList<>(); 
        q.add(new Pair(0, root)); 
        while (!q.isEmpty()) {
            Pair pair = q.poll(); 
            Node node = pair.node; 
            int level = pair.level; 
            map.put(level, node.data); 
            if(node.left != null){
                q.add(new Pair(level+1, node.left)); 
            }
            if(node.right != null){
                q.add(new Pair(level+1, node.right)); 
            }
        }
        // System.out.println(map.values());
        for(Integer i : map.values()){
            list.add(i); 
        }
        return list; 
    }
}
