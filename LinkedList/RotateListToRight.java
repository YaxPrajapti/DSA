package LinkedList;

public class RotateListToRight {
    public static void main(String[] args) {
        Node head = new Node(1); 
        head.next = new Node(2); 
        head.next.next = new Node(3); 
        head.next.next.next = new Node(4); 
        head.next.next.next.next = new Node(5); 
        int k = 2; 
        Node newhead = rotateright(head, k); 
        while(newhead != null){
            System.out.print(newhead.data + " => ");
            newhead = newhead.next; 
        }
    }
    //Logic: crete list into circular list and then make the pointer len-k-1.next = null; 
    public static Node rotateright(Node head, int k){
        if(head == null || head.next == null){
            return head;
        }
        int len = length(head); 
        k = k % len; 
        if(k == 0){
            return head;
        }
        Node temp = head; 
        while(temp.next != null){
            temp = temp.next; 
        }
        temp.next = head; 
        Node tail = head; 
        for(int i = 0; i < len-k-1; i++){
            tail = tail.next; 
        }
        head = tail.next; 
        tail.next = null; 
        return head; 
    }
    private static int length(Node head){
        int len = 0; 
        Node node = head; 
        while(node != null){
            len++; 
            node = node.next; 
        }
        return len; 
    }
}
