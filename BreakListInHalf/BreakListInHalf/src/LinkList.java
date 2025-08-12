
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
}
