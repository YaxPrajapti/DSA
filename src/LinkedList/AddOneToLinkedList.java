package LinkedList;

public class AddOneToLinkedList {
    public static void main(String[] args) {
        Node head = new Node(9); 
        head.next = new Node(9); 
        // head.next.next = new Node(9); 
        Node newHead = addOneToList(head); 
        while(newHead != null){
            System.out.print(newHead.data + " => ");
            newHead = newHead.next; 
        }
    }
    public static Node addOneToList(Node head){
        if(head == null){
            return new Node(1); 
        }
        Node reversedHead = reverse(head); 
        int carryFlag = 0; 
        Node i = reversedHead; 
        //add one; 
        int sum = i.data + 1; 
        if(sum > 9){
            i.data = 0; 
            carryFlag = 1; 
        }else{
            i.data = sum; 
        }
        while(carryFlag == 1){
            if(i.next == null){
                i.next = new Node(1); 
                carryFlag = 0; 
            } else {
                i = i.next;
                sum = i.data + carryFlag;
                if (sum < 10) {
                    i.data = sum;
                    carryFlag = 0;
                } else {
                    i.data = 0;
                }
            }
        }
        
        return reverse(reversedHead); 
    }
    private static Node reverse(Node head){
        if(head == null || head.next == null){
            return head; 
        }
        Node next = null; 
        Node prev = null; 
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
