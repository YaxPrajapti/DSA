package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * InnerBottomView
 */


public class BottomView {
    static class Pair {
    int vertical;
    Node node;
    Pair(Node node, int vertical) {
        this.vertical = vertical;
        this.node = node;
    }
}
    public static void main(String[] args) {
        Node root = new Node(20); 
        root.left = new Node(8); 
        root.left.left = new Node(5); 
        root.left.right = new Node(3); 
        root.left.right.left = new Node(10); 
        root.left.right.right = new Node(14); 
        root.right = new Node(22); 
        root.right.left = new Node(4); 
        root.right.right = new Node(25); 
        ArrayList<Integer> list = bottomView(root);
        System.out.println(list);
    }

    public static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int vertical = pair.vertical;
            Node node = pair.node;
            map.put(vertical, node.data);
            if (node.left != null) {
                q.add(new Pair(node.left, vertical - 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, vertical + 1));
            }
        }
        for (Integer i : map.values()) {
            list.add(i);
        }
        return list;
    }
}
