package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;


/**
 * root
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

/**
 * Pair
 */
class Pair {
    int vertical; 
    Node node; 
    Pair(int vertical, Node node){
        this.vertical = vertical; 
        this.node = node; 
    }
}

public class TopViewOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1); 
        root.left = new Node(2); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right = new Node(3);   
        root.right.left = new Node(6); 
        root.right.left.right = new Node(8); 
        root.right.right = new Node(7); 
        root.right.right.right = new Node(9); 
        ArrayList<Integer> topviewList = topView(root); 
        System.out.println(topviewList);
    }
    public static ArrayList<Integer> topView(Node root){
        ArrayList<Integer> list = new ArrayList<>(); 
        TreeMap<Integer, Integer> map = new TreeMap<>(); 
        Queue<Pair> q = new LinkedList<>(); 
        q.add(new Pair(0, root)); 
        while(!q.isEmpty()){
            Pair pair = q.poll(); 
            int vertical = pair.vertical; 
            Node node = pair.node; 
            if(!map.containsKey(vertical)){
                map.put(vertical, node.data); 
            }
            if(node.left != null){
                q.add(new Pair(vertical-1, node.left)); 
            }
            if(node.right != null){
                q.add(new Pair(vertical+1, node.right)); 
            }
        }
        for(Integer i : map.values()){
            list.add(i); 
        }
        return list; 
    }
    
}
