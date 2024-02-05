package BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import Arrays.sort2DArray;

public class MinTimeToBurnTree {
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
        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.left.right.left = new Node(7);
        // root.left.right.right = new Node(8);
        // root.right = new Node(3);
        // root.right.right = new Node(6);
        // root.right.right.right = new Node(9);
        // root.right.right.right.right = new Node(10);
        Node root = new Node(1); 
        root.left = new Node(2); 
        root.left.left = new Node(4); 
        root.left.left.left = new Node(8); 
        root.left.right = new Node(5); 
        root.left.right.left = new Node(10); 
        root.right = new Node(3); 
        root.right.right = new Node(7);     
        int minTime = minTime(root, 10);
        System.out.println("Time"+minTime);
    }

    public static int minTime(Node root, int target) {
        Map<Node, Node> parent_track = new HashMap<>();
        mark_parents(root, parent_track);
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node targetNode = findNode(target, root);
        q.add(targetNode);
        visited.put(targetNode, true);
        int time = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                // check left;
                if (node.left != null && visited.get(node.left) == null) {
                    visited.put(node.left, true);
                    q.add(node.left);
                }
                // check right;
                if (node.right != null && visited.get(node.right) == null) {
                    visited.put(node.right, true);
                    q.add(node.right);
                }
                // check parent;
                if (parent_track.get(node) != null && visited.get(parent_track.get(node)) == null) {
                    visited.put(parent_track.get(node), true);
                    q.add(parent_track.get(node));
                }
            }

        }
        return time;
    }

    private static Node findNode(int target, Node root) {
        if (root == null) {
            return root;
        }
        if(root.data == target){
            return root; 
        }
        Node left = findNode(target, root.left);
        if(left != null){
            return left; 
        }
        Node right = findNode(target, root.right);
        if(right != null){
            return right; 
        }
        return null; 
    }

    private static void mark_parents(Node root, Map<Node, Node> map) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (node.left != null) {
                    map.put(node.left, node);
                    q.add(node.left);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    q.add(node.right);
                }
            }
        }
    }
}
