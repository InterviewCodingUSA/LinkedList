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

    // Delete Middle of list
    public void deleteMiddle(){
        if(head == null || head.next == null || head.next.next == null){ // If list is empty or single node
            return ;
        }
        Node<T> front = head; // Fast pointer
        Node<T> back = head; // Slow pointer
        while(front.next.next != null){ // Move pointers to find middle -1 node
            front = front.next;
            if(front.next.next != null){
                front = front.next;
                back = back.next;
            }
        }
        Node<T> delNode = back.next;
        back.next = back.next.next;
        delNode.next = null;
        delNode = null;
    }

}
