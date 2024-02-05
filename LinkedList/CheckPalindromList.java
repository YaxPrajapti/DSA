package LinkedList;


public class CheckPalindromList {
    public static void main(String[] args) {
        Node head = new Node(1); 
        head.next = new Node(2); 
        head.next.next = new Node(1); 
        // head.next.next.next.next = new Node(5);     
        boolean isPal = isPalindrom(head); 
        System.out.println(isPal);
    }
    public static boolean isPalindrom(Node head){
        if(head == null || head.next == null){
            return true; 
        }
        Node slow = head; 
        Node fast = head; 
        // find the middle of the list
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next; 
            slow = slow.next;   
        }
        //now reverse the right half after the slow node. 
        slow.next = reverse(slow.next); 
        slow = slow.next; 
        while(slow!=null){
            if(head.data != slow.data){
                return false; 
            }
            slow = slow.next; 
            head = head.next; 
        }
        return true; 
    }
    private static Node reverse(Node head){
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

