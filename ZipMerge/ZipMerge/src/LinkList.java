// A generic singly linked list implementation with comparable elements
public class LinkList <T extends Comparable<T>>{

    // Head node of the linked list
    public Node<T> head;
    // Tail node of the linked list
    public Node<T> back;
    // Length of the linked list
    public Integer length;

    // Constructor to initialize an empty linked list
    public LinkList(){
        head = null;
        back = null;
        length = 0;
    }


    // Reverses a sublist starting from given node
    public Node<T> reverseList(Node<T> node){
        if(node == null || node.next == null){ // If empty or single node
            return node;
        }
        Node<T> back = null; // Previous node
        Node<T> mid = node; // Current node
        Node<T> front = node.next; // Next node

        while(front != null){ // Traverse until end
            mid.next = back; // Reverse link
            back = mid; // Move back to current
            mid = front; // Move current to next
            front = front.next; // Move next forward
        }
        mid.next = back; // Connect last node
        node = mid; // Update node to new head
        return node; // Return new head
    }

    // Splits the list into two halves and returns the head of the second half
    public Node<T> breakListInHalf(){
        if(head == null || head.next == null){ // If list is empty or single node
            return null;
        }
        Node<T> front = head; // Fast pointer
        Node<T> back = head; // Slow pointer
        while(front.next != null){ // Move pointers to find middle
            front = front.next;
            if(front.next != null){
                front = front.next;
                back = back.next;
            }
        }
        Node<T> temp = back.next; // Store second half head
        back.next = null; // Break list
        return temp; // Return second half head
    }

    // Merges two halves of the list in a zip-like fashion
    public void zipMerge(){
        if(head == null || head.next == null){ // If empty or single node
            return;
        }
        Node<T> secondHalf = breakListInHalf(); // Get second half
        secondHalf = reverseList(secondHalf); // Reverse second half
        Node<T> temp1 = head; // First half pointer
        Node<T> temp2 = secondHalf; // Second half pointer
        boolean bSwitch = true; // Switch to alternate nodes
        Node<T> next = null; // Temporary pointer

        while(temp1 != null && temp2 != null){ // Interleave nodes
            if(bSwitch){
                next = temp1.next; // Save next node
                temp1.next = temp2; // Link to second half node
                bSwitch = false; // Switch to second half
                temp1 = next; // Move to next first half node
            }else{
                next = temp2.next; // Save next node
                temp2.next = temp1; // Link to first half node
                bSwitch = true; // Switch to first half
                temp2 = next; // Move to next second half node
            }
        }
    }
}
