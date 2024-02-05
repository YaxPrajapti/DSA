package BinaryTree;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PathsFromRootWithSpecifiedSum {
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
//        Node root = new Node(1);
        Node root = new Node(10);
        root.left = new Node(28);
        root.right = new Node(13);
        root.right.left = new Node(14);
        root.right.left.left = new Node(21);
        root.right.left.right = new Node(22);
        root.right.right = new Node(15);
        root.right.right.left = new Node(23);
        root.right.right.right = new Node(24);
//        Node root = new Node(0);
//        root.left = new Node(0);
//        root.left.left = new Node(1);
//        root.left.right = new Node(-4);
//        root.left.left.left = new Node(3);
//        root.left.left.right = new Node(0);
//        root.right = new Node(-3);
//        Node root = new Node(-2);
//        root.left = new Node(-4);
//        root.left.left = new Node(0);
//        root.left.right = new Node(3);
//        root.right = new Node(-1);
//        root.right.left = new Node(0);
//        root.left.left.left = new Node(4);
//        root.left.left.right = new Node(2);
//        root.right.left.left = new Node(1);
        ArrayList<ArrayList<Integer>> ans = printPaths(root, 38);
        System.out.println("ans = " + ans);
    }

    public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        preOrder(root, sum, ans, new ArrayList<>(), 0);
        return ans;
    }

    private static void preOrder(Node root, int sum, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp, int tempSum) {
        if(root == null){
            return;
        }
        tempSum += root.data;
        temp.add(root.data);
        if(tempSum == sum){
            ans.add(new ArrayList<>(temp));
        }
        //pre order traversal
        preOrder(root.left, sum, ans, temp, tempSum);
        preOrder(root.right, sum, ans, temp, tempSum);
        temp.remove(temp.size()-1);
    }
}
