
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

    // Prints the entire list starting from head
    public void printList(){
        Node<T> temp = head; // Start from head
        while(temp != null){ // Traverse until end
            System.out.print(temp.data + " -> "); // Print current node data
            temp = temp.next; // Move to next node
        }
        System.out.println("NULL"); // Indicate end of list
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

    public Integer binartyToInteger(){
        if(length == 0){
            return 0;
        }
        Integer value = 0;
        Node<T> temp = head;
        Integer exp = length -1;
        while(temp != null){
            value += (Integer) temp.data * 2^exp;
            exp --;
            temp = temp.next;
        }
        return  value;
    }
}
