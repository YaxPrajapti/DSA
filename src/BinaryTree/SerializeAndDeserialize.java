package BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;




public class SerializeAndDeserialize {
    static class TreeNode{
        int data; 
        TreeNode left; 
        TreeNode right; 
        TreeNode(int data){
            this.data = data; 
            this.left = null;
            this.right = null; 
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1); 
        root.left = new TreeNode(2); 
        root.right = new TreeNode(3); 
        root.right.left = new TreeNode(4); 
        root.right.right = new TreeNode(5); 
        System.out.println(serialize(root));
    }
    public static String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder(); 
        helperSerialize(root, sb); 
        return sb.toString(); 
    }
    private static void helperSerialize(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("Null").append(',');
            return;  
        }
        sb.append(root.data).append(',');
        helperSerialize(root.left, sb);
        helperSerialize(root.right, sb);
    }
    public static TreeNode deserialize(String data){
        Queue<String> q = new LinkedList<>(); 
        String[] values = data.split(",");
        q.addAll(Arrays.asList(values)); 
        return helperDeserialize(q);
    }
    private static TreeNode helperDeserialize(Queue<String> q){
        String val = q.remove(); 
        if(val == "Null"){
            return null; 
        }
        TreeNode node = new TreeNode(Integer.valueOf(val)); 
        node.left = helperDeserialize(q); 
        node.right = helperDeserialize(q); 
        return node; 
    }
}
