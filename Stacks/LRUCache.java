package Stacks;

import java.util.ArrayList;
import java.util.HashMap;

public class LRUCache {
    
    HashMap<Integer, Node> cache_map; 
    Node head = new Node(); 
    Node tail = new Node();
    int capacity; 
    public LRUCache(int capacity) {
        this.capacity = capacity; 
        this.cache_map = new HashMap<>(capacity); 
        head.next = tail; 
        tail.prev = head;  
    }

    public int get(int key) {
        if(cache_map.size() == 0){
            return -1; 
        }
        Node node = cache_map.get(key); 
        if(node != null){
            remove_node(node);
            add_node(node);
            return node.val; 
        }
        return -1; 
    }

    public void put(int key, int val) {
        Node node = cache_map.get(key); 
        if(node != null){
            remove_node(node); 
            node.val = val; 
            add_node(node);
        }else{
            if(cache_map.size() == capacity){
                cache_map.remove(tail.prev.key); 
                remove_node(tail.prev);
            }
            Node new_node = new Node(key, val); 
            cache_map.put(key, new_node);
            add_node(new_node);
        }
    }

    private void add_node(Node node){
        Node head_next = head.next; 
        node.next = head_next; 
        head_next.prev = node; 
        head.next = node; 
        node.prev = head; 
    }
     
    private void remove_node(Node node){
        Node next_node = node.next; 
        Node prev_node = node.prev; 

        next_node.prev = node.prev; 
        prev_node.next = node.next; 

    }

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node() {
            this.next = null;
            this.prev = null;
        }

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }


    public static void main(String[] args) {

    }
}
