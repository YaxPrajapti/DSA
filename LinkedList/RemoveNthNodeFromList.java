package LinkedList;

public class RemoveNthNodeFromList {
    public static void main(String[] args) {
        Node head = new Node(1); 
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4); 
        // head.next.next.next.next = new Node(5); 
        Node newhead = removeNthNode(head, 1); 
        while(newhead != null){
            System.out.print(newhead.data + " => ");
            newhead = newhead.next; 
        }
    }
    public static Node removeNthNode(Node head, int n){
        if(head.next == null){
            head = null; 
            return head; 
        }
        int len = getLenght(head); 
        if(len == n){
            head = head.next; 
            return head; 
        }
        int nodeTodelete = len - n; 
        Node node = head; 
        for(int i = 1; i < nodeTodelete; i++){
            node = node.next; 
        }
        node.next = node.next.next; 
        return head; 
    }
    private static int getLenght(Node head){
        Node node = head; 
        int len =0; 
        while(node != null){
            len++; 
            node = node.next; 
        }
        return len; 
    }
}
