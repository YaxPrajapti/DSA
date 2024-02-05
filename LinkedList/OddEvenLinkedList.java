package LinkedList;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1); 
        head.next = new Node(2); 
        head.next.next = new Node(3); 
        head.next.next.next = new Node(4); 
        // head.next.next.next.next = new Node(5); 
        Node newHead = oddEvenList(head); 
        while(newHead != null){
            System.out.print(newHead.data + "=>");
            newHead = newHead.next; 
        }

    }
    public static Node oddEvenList(Node head){
        if(head == null || head.next == null){
            return head; 
        }
        Node odd = head; 
        Node even = head.next; 
        Node dummy = head.next; 
        while(odd.next!= null && even.next != null){
            odd.next = even.next; 
            odd = odd.next; 
            if(odd.next != null){
                even.next = odd.next; 
                even = even.next; 
            }
        }
        // if(even.next == null){
        //     odd.next = dummy; 
        // }else{
        //     odd.next = dummy; 
        //     even.next = null; 
        // }
        if(odd.next == null){
            even.next = null; 
        }
        odd.next = dummy; 
        return head; 
    }
    
}
