
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


    // Inserts a new node with given data in sorted order
    public void sortedInsert(T data){
        Node<T> addNode = new Node<>(data); // Create new node
        length++; // Increment length
        if(head == null){ // If list is empty
            head = addNode;
            back = head;
            return;
        }
        if(head.data.compareTo(data) >= 0){ // If new node goes at head
            addNode.next = head;
            head = addNode;
            return;
        }
        if(back.data.compareTo(data) <= 0){ // If new node goes at end
            back.next = addNode;
            back = addNode;
            return;
        }
        Node<T> temp = head; // Traverse to find insertion point
        while(temp.next.data.compareTo(data) < 0){ // Find position
            temp = temp.next;
        }
        addNode.next = temp.next; // Insert node
        temp.next = addNode;
    }

    // Returns the data of the nth node from the end of the list
    public void swapNthFromEnd(int n){
        if(n <= 0){ // Check for invalid input
            return ;
        }
        Node<T> front = head; // Front pointer
        Node<T> back = head; // Back pointer
        for(int i = 0; i < n; i++){ // Move front pointer n nodes ahead
            if(front == null){ // If list is too short
                return;
            }
            front = front.next;
        }

        Node<T> nthNode = back; // This is the node nth From start

        while(front != null){ // Move both pointers until front reaches end
            front = front.next;
            back = back.next;
        }
        // Swap Nodes data.
        T data = nthNode.data;
        nthNode.data = back.data;
        back.data = data;
    }
}
