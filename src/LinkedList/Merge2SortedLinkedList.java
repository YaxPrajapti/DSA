package LinkedList;

public class Merge2SortedLinkedList {
    static class Node{
        int data; 
        Node next; 
        Node(int data){
            this.data = data; 
            this.next = null; 
        }
    }
    public static void main(String[] args) {
        Node head1 = new Node(2); 
        head1.next = new Node(4);
        head1.next.next = new Node(5); 
        Node head2 = new Node(1); 
        head2.next = new Node(1); 
        head2.next.next = new Node(2);
        head2.next.next.next = new Node(3); 
        head2.next.next.next.next = new Node(3); 
        head2.next.next.next.next.next = new Node(5); 
        head2.next.next.next.next.next.next = new Node(11);
        head2.next.next.next.next.next.next.next = new Node(19); 
        Node node = mergeResult(head1, head2); 
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next; 
        }
    }
    public static Node mergeResult(Node node1, Node node2){
        if(node1 == null){
            return node2; 
        }
        if(node2 == null){
            return node1; 
        }
        Node i = null; 
        Node j = null; 
        Node head; 
        if(node1.data < node2.data){
            i = node1; 
            j = node2; 
        }else if(node1.data > node2.data){
            i = node2; 
            j = node1; 
        }
        head = i; 
        while (i != null && j != null) {
            Node temp = null; 
            while (i!=null && i.data <= j.data) {
                temp = i; 
                i = i.next; 
            }
            temp.next = j; 
            temp = i; 
            i = j; 
            j = temp; 

        }
        return reverse(head);  
    }
    public static Node reverse(Node head){
        Node curr = head; 
        Node next = null; 
        Node prev = null;
        while (curr != null) {
            next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next; 
        } 
        return prev; 
    }
}
