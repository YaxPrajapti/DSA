package LinkedList;

public class FindLengthOfCycle {
    public static void main(String[] args) {
        Node head = new Node(4);
        Node pos = new Node(10);
        head.next = pos;
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = pos;
        int lengthOfCycle = findLengthOfCycle(head);
        System.out.println(lengthOfCycle);
    }

    public static int findLengthOfCycle(Node head){
        Node slow = head; 
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next; 
            fast = fast.next.next; 
            //there is a loop. 
            if(slow == fast){
                slow = head; 
                //now find starting point of cycle 
                while(slow != fast){
                    slow = slow.next; 
                    fast = fast.next; 
                }
                //now move slow and find length; 
                int counter = 1; 
                slow = slow.next; 
                while(slow != fast){
                    slow = slow.next; 
                    counter++; 
                }
                return counter; 
            }
        }
        return 0; 
    }
}
