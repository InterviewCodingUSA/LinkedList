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

    public Integer maxTwinSumValue(){
        if(length <= 0 || length%2 != 0){
            return Integer.MIN_VALUE;
        }
        Node<T> secondHalf = breakListInHalf();
        secondHalf = reverseList(secondHalf);
        Node<T> tempFirst = head;
        Node<T> tempSecond = secondHalf;
        Integer maxTwinValue = (Integer) tempFirst.data + (Integer) tempSecond.data;
        while (tempFirst != null){
            Integer twinValue = (Integer) tempFirst.data + (Integer) tempSecond.data;
            if(twinValue > maxTwinValue){
                maxTwinValue = twinValue;
            }
            tempFirst = tempFirst.next;
            tempSecond = tempSecond.next;
        }
        return maxTwinValue;
    }
}
