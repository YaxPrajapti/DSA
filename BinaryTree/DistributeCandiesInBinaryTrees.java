package BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DistributeCandiesInBinaryTrees {
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
    static int[] moves = {0};
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(0);
        root.right = new Node(0);
        root.left.right = new Node(3);
        int ans = distributeCandy(root);
        System.out.println(ans);
    }
    public static int distributeCandy(Node root) {
        traverse(root, moves);
        return moves[0];
    }
    private static int traverse(Node root, int[] moves){
        if(root == null){
            return 0;
        }
        //we will see how many coins does left and right subtree wants;
        int left = traverse(root.left, moves);
        int right = traverse(root.right, moves);
        //now we will update our moves:
        //we will use the abs value for left and right subtree.
        //if left node has 0 coins then it needs 1 coin (excess of -1) and need 1 move to fill
        //if left or right node has 4 candies then it needs 3 moves to push the candies to parent or other node
        moves[0] += Math.abs(left) + Math.abs(right);
        //will return how many moves from that node is required to balance the current node.
        return root.data - 1 + left + right;
    }
}
