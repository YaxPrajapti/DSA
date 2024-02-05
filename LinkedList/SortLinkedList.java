package LinkedList;

public class SortLinkedList {
    public static void main(String[] args) {
        Node head = new Node(-1); 
        head.next = new Node(5); 
        head.next.next = new Node(3); 
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(0);  
        Node newhead = sortList(head); 
        while(newhead!=null){
            System.out.print(newhead.data + " => ");
            newhead = newhead.next; 
        }
    }
    public static Node sortList(Node head){
        if(head == null || head.next == null){
            return head; 
        }
        Node slow = head; 
        Node fast = head; 
        Node temp = head; 
        while(fast != null && fast.next != null){
            temp = slow; 
            slow = slow.next; 
            fast = fast.next.next; 
        }
        //break two lists. 
        temp.next = null; 
        Node lefthalf = sortList(head); 
        Node righthalf = sortList(slow); 
        return merge(lefthalf, righthalf); 
    }
    private static Node merge(Node l1, Node l2){
        Node fakeNode = new Node(0); 
        Node temp = fakeNode;  
        while(l1 != null && l2 != null){
            if(l1.data <= l2.data){
                temp.next = l1; 
                temp = temp.next; 
                l1 = l1.next; 
            }else{
                temp.next = l2; 
                temp = temp.next; 
                l2 = l2.next; 
            }
        }
        while(l1 != null){
            temp.next = l1; 
            temp = temp.next; 
            l1 = l1.next; 
        }
        while(l2 != null){
            temp.next = l2; 
            temp = temp.next; 
            l2 = l2.next; 
        }
        return fakeNode.next; 
    }
}

