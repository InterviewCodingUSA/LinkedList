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

    // Reverses the entire linked list iteratively
    public void reverseList(){
        if(head == null || head.next == null){ // If list is empty or single node
            return;
        }
        Node<T> back = null; // Previous node
        Node<T> mid = head; // Current node
        Node<T> front = head.next; // Next node

        while(front != null){ // Traverse until end
            mid.next = back; // Reverse link
            back = mid; // Move back to current
            mid = front; // Move current to next
            front = front.next; // Move next forward
        }
        mid.next = back; // Connect last node
        head = mid; // Update head to new first node
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

    // Reverses the list using recursion
    public void reverse() {
        // If list is empty or has only one node, no need to reverse
        if (head == null || head.next == null) {
            return;
        }
        // Call recursive helper method and update head
        head = reverseRecursive(head);
        // Update back pointer to point to the last node (original head)
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        back = current; // Set back to last node
    }

    // Helper method to recursively reverse the list
    private Node<T> reverseRecursive(Node<T> current) {
        // Base case: if current is null or last node, return it
        if (current == null || current.next == null) {
            return current;
        }

        // Recursive call: reverse the rest of the list
        Node<T> newHead = reverseRecursive(current.next);

        // Adjust pointers: make the next node point to current
        current.next.next = current;
        current.next = null;

        return newHead; // Return new head
    }
}
