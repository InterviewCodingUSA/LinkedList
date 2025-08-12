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

    // Finds the last node of a given list segment
    public Node<T> findLastNode(Node<T> node){
        if(node == null || node.next == null){ // If empty or single node
            return node;
        }
        Node<T> temp = node; // Start from given node
        while(temp.next != null){ // Traverse to end
            temp = temp.next;
        }
        return temp; // Return last node
    }


    // Checks if the linked list is a palindrome
    public boolean isPalindrome(){
        boolean isPalindrome = true; // Initialize result
        if(head == null || head.next == null){ // If empty or single node
            return true;
        }
        Node<T> secondHalf = breakListInHalf(); // Get second half
        secondHalf = reverseList(secondHalf); // Reverse second half

        Node<T> temp1 = head; // First half pointer
        Node<T> temp2 = secondHalf; // Second half pointer

        while(temp1 != null && temp2 != null){ // Compare halves
            if(temp1.data != temp2.data){ // If mismatch found
                isPalindrome = false;
                break;
            }
            temp1 = temp1.next; // Move first half pointer
            temp2 = temp2.next; // Move second half pointer
        }

        // Restore the list
        secondHalf = reverseList(secondHalf); // Reverse second half back
        Node<T> lastNode = findLastNode(head); // Find end of first half
        lastNode.next = secondHalf; // Reconnect halves
        return isPalindrome; // Return result
    }

}
