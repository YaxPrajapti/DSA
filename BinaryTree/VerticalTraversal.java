package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalTraversal {
    /**
     * Tuple
     */
    static class Tuple {
        Node node;
        int row;
        int col;

        Tuple(Node node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(8);
        root.right.right.right = new Node(9);
        List<List<Integer>> list = verticalTraversal(root); 
        System.out.println(list);
    }

    public static List<List<Integer>> verticalTraversal(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        while (!q.isEmpty()) {
            Tuple tuple =q.poll(); 
            Node node = tuple.node; 
            int x = tuple.row; 
            int y = tuple.col; 

            //check if map contains this vertical; 
            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>()); 
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>()); 
            }
            map.get(x).get(y).add(node.data); 
            if(node.left != null){
                q.add(new Tuple(node.left, x-1, y+1));
            }
            if(node.right != null){
                q.add(new Tuple(node.right, x+1, y+1)); 
            }
        }
        for(TreeMap<Integer, PriorityQueue<Integer>> x : map.values()){
            list.add(new ArrayList<>()); 
            for(PriorityQueue<Integer> nodes : x.values()){
                while (!nodes.isEmpty()) {
                    list.get(list.size()-1).add(nodes.poll()); 
                }
            } 
        }
        return list; 
    }

}
