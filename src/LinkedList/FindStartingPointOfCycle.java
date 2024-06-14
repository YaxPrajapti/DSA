package LinkedList;

import java.util.HashSet;
import java.util.Map;

public class FindStartingPointOfCycle {
    public static void main(String[] args) {
        Node head = new Node(3); 
        Node prev = new Node(2);
        head.next = prev; 
        head.next.next = new Node(0); 
        Node tail = new Node(-4); 
        head.next.next.next = tail; 
        head.next.next.next.next = head.next; 
        Node cycleStartingPoint = detectCycle(head); 
        System.out.println(cycleStartingPoint.data);
    }
    /*
    Brute force solution: 
    public static Node detectCycle(Node head){
        if(head == null){
            return head; 
        }
        HashSet<Node> set = new HashSet<>(); 
        Node node = head; 
        while(node != null){
            if(set.contains(node)){
                return node; 
            }
            set.add(node); 
            node = node.next; 
        }
        return null; 
    }
     */

    public static Node detectCycle(Node head ){
        if(head == null){
            return head; 
        }
        Node slow = head; 
        Node fast = head; 
        while(fast != null && fast.next != null){
            slow = slow.next; 
            fast = fast.next.next; 
            //we will have loop if slow == fast. 
            if(slow == fast){
                slow = head; 
                while(slow != fast){
                    slow = slow.next; 
                    fast = fast.next; 
                }
                return fast; 
            }
        }
        return null; 
    }
}
