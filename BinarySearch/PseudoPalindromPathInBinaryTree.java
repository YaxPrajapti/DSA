package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class PseudoPalindromPathInBinaryTree {
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
        Node root = new Node(2);
        root.left = new Node(3);
        root.left.left = new Node(3);
        root.left.right = new Node(1);
        root.right = new Node(1);
        root.right.right = new Node(1);
        int counts = pseudoPalindromicPaths(root);
        System.out.println(counts);
    }
    public static int pseudoPalindromicPaths(Node root){
        if(root == null){
            return 0;
        }
        int[] arr = new int[10];
        Arrays.fill(arr, 0);
        int[] count = {0};
        traverse(root, arr, count);
        return count[0];
    }
    private static void traverse(Node root, int[] arr, int[] count){
        if(root == null){
            return;
        }
        arr[root.data]++;
        traverse(root.left, arr, count);
        traverse(root.right, arr, count);
        if(root.left == null && root.right == null){
            int odd = 0;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] % 2 == 1){
                    odd++;
                }
            }
            if(odd == 1 || odd == 0){
                count[0]++;
            }
        }
        arr[root.data]--;
    }
}
