package LinkedList;

public class DeleteMiddleNodeOfLinkedList {
    public static void main(String[] args) {
        Node head = new Node(2); 
        head.next = new Node(1); 
        // head.next.next = new Node(4); 
        // head.next.next.next = new Node(7);
        // head.next.next.next.next = new Node(1); 
        // head.next.next.next.next.next = new Node(2);
        // head.next.next.next.next.next.next = new Node(6);  
        Node newHead = deleteMidNode(head); 
        while(newHead != null){
            System.out.print(newHead.data + " => ");
            newHead = newHead.next; 
        }
    }
    public static Node deleteMidNode(Node head){
        if(head == null || head.next == null){
            return null; 
        }
        Node slow = head; 
        Node fast = head; 
        while(fast.next.next != null && fast.next.next.next != null){
            slow = slow.next; 
            fast = fast.next.next; 
        }
        slow.next = slow.next.next; 
        return head; 
    }
}
