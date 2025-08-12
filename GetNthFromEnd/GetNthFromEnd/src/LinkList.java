
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

    // Returns the data of the nth node from the end of the list
    public T nthFromEnd(int n){
        if(n <= 0){ // Check for invalid input
            return null;
        }
        Node<T> front = head; // Front pointer
        Node<T> back = head; // Back pointer
        for(int i = 0; i < n; i++){ // Move front pointer n nodes ahead
            if(front == null){ // If list is too short
                return null;
            }
            front = front.next;
        }

        while(front != null){ // Move both pointers until front reaches end
            front = front.next;
            back = back.next;
        }
        return back.data; // Return nth node from end's data
    }

}
