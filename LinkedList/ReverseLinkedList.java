package LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1); 
        head.next = new Node(2); 
        head.next.next = new Node(3); 
        head.next.next = new Node(4); 
        Node reversedNode = reverseList(head); 
        Node temp = reversedNode; 
        while(temp != null){
            System.out.print(temp.data + " => ");
            temp = temp.next; 
        }
    }
    public static Node reverseList(Node head){
        Node prev = null; 
        Node next = null; 
        Node curr = head; 
        while(curr != null){
            next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next; 
        }
        return prev; 
    }
}
