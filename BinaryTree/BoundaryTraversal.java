package BinaryTree;

import java.util.ArrayList;

public class BoundaryTraversal {
    /**
     * InnerBoundaryTraversal
     */
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
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        ArrayList<Integer> boundary = boundary(root);
        System.out.println(boundary);
    }

    public static ArrayList<Integer> boundary(Node node) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(node.data);

        ArrayList<Integer> leftTraversal = new ArrayList<>();
        leftTraversal(node.left, leftTraversal);

        ArrayList<Integer> rightTraversal = new ArrayList<>();
        rightTraversal(node.right, rightTraversal);

        ArrayList<Integer> leafTraversal = new ArrayList<>();
        leafTraversal(node, leafTraversal);

        // insert the left traversal to the list;
        for (int i = 0; i < leftTraversal.size(); i++) {
            list.add(leftTraversal.get(i));
        }
        // insert the leaf traversal to the list
        for (int i = 0; i < leafTraversal.size(); i++) {
            list.add(leafTraversal.get(i));
        }
        // insert the right traversal to the list
        for (int i = 0; i < rightTraversal.size(); i++) {
            list.add(rightTraversal.get(i));
        }
        return list;
    }

    private static void leftTraversal(Node node, ArrayList<Integer> list) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }
        list.add(node.data);
        if (node.left != null) {
            leftTraversal(node.left, list);
        } else {
            leftTraversal(node.right, list);
        }
    }

    private static void rightTraversal(Node node, ArrayList<Integer> list) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }

        list.add(0, node.data);

        if (node.right != null) {
            rightTraversal(node.right, list);
        } else {
            rightTraversal(node.left, list);
        }

    }

    private static void leafTraversal(Node node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        
        leafTraversal(node.left, list);
        leafTraversal(node.right, list);
        if (node.left == null && node.right == null) {
            list.add(node.data);
        }
    }
}
