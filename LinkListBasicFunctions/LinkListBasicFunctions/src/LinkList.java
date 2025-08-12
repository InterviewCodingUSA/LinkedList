
// A generic singly linked list implementation with comparable elements
public class LinkList<T extends Comparable<T>>{

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

    // region Generic functions of a Single link List

    // Prints the entire list starting from head
    public void printList(){
        Node<T> temp = head; // Start from head
        while(temp != null){ // Traverse until end
            System.out.print(temp.data + " -> "); // Print current node data
            temp = temp.next; // Move to next node
        }
        System.out.println("NULL"); // Indicate end of list
    }

    // Prints the list starting from a given node
    public void printList(Node<T> node){
        Node<T> temp = node; // Start from given node
        while(temp != null){ // Traverse until end
            System.out.print(temp.data + " -> "); // Print current node data
            temp = temp.next; // Move to next node
        }
        System.out.println("NULL"); // Indicate end of list
    }

    // Calculates and returns the length of the list
    // Not really needed since we have length property which can give length in O(1)
    // Added this for a generic understanding if we dont have length property
    public Integer lengthOfList(){
        Node<T> temp = head; // Start from head
        int length = 0; // Initialize counter
        while(temp != null){ // Traverse until end
            length++; // Increment counter
            temp = temp.next; // Move to next node
        }
        return length; // Return total length
    }

    // Adds a new node to the head of the List
    // Complexity O(1)
    public void add(T data){
        Node<T> addNode = new Node<>(data);
        addNode.next = head;
        head = addNode;
        if(back == null){
            back = head;
        }
        length++;
    }

    // Adds a new node in the back of the list O(1)
    // Complexity O(1)
    public void addLast(T data){
        Node<T> addNode = new Node<>(data);
        if(back == null){
            head = addNode;
            back = addNode;
        }else{
            back.next = addNode;
        }
        length++;
    }

    // Find of the list if empty
    public boolean isEmpty(T data){
        return  head == null;
    }

    // Get Value of a node at a particular index, return null if list is empty
    // or list is smaller than index
    // Complexity O(n)
    public T get(int index){
        // Check base conditions
        if(index < 0 || head == null){
            return  null;
        }
        // Loop through the lust
        Node<T> temp = head;
        while( index  != 0){
            if(temp == null){
                return null; // Return if number of nodes is less than index
            }
            temp = temp.next;
            index --;
        }
        return temp.data;
    }

    // Adds a node at index, with data, returns true/false if the call is successful
    // Complexity O(n)
    public boolean add(int index, T data){
        // Base condition
        if(index < 0){
            return false;
        }
        // Loop through the list and return false if the list is smaller than index
        // Go to index -1 since we have to add the node at index
        Node<T> temp = head;
        while( index  != 1){
            if(temp == null){
                return false;
            }
            temp = temp.next;
            index --;
        }
        // Add the node
        Node<T> addNode = new Node<>(data);
        addNode.next = temp.next;
        temp.next = addNode;
        length ++;
        return true;
    }

    // Clears the list
    public void clear(){
        head = null;
        back = null;
        length = 0;
    }

    // Creates clone of a linked list
    public LinkList<T> cloneList(){
        // Create a new Link List and check for base condition
        LinkList<T> list = new LinkList<>();
        if(head == null){
            return list;
        }

        // Initialize the head and create temp pointers for looping through the original list
        list.head = new Node<>(head.data);
        Node<T> tempOld = head.next;
        Node<T> tempNew = list.head;
        // Loop through the list and
        while(tempOld != null){
            tempNew.next = new Node<>(tempOld.next.data);
            tempNew = tempNew.next;
            tempOld = tempOld.next;
        }
        list.length = length;
        return list;
    }

    public Node<T> getFirst(){
        return head;
    }
    public Node<T> getLast(){
        return back;
    }

    // Sets data for a node at a particular index
    // Complexity  O(n)
    public boolean set(int index, T data){
        // Check for base condition
        if(index < 0){
            return false;
        }
        // Loop through the list and break if list is smaller than index
        Node<T> temp = head;
        while( index  != 1){
            if(temp == null){
                return false;
            }
            temp = temp.next;
            index --;
        }
        temp.data = data;
        return true;
    }

    // Removes first node of the list
    // Complexity O(1)
    public void removeFirst(){
        // Base condition
        if(head == null){
            return;
        }
        Node<T> temp = head;
        head = head.next;
        temp.next = null;
        temp = null;
        length --;
    }

    // Removes last node of the list
    public void removeLast(){
        // Base condition
        if(head == null || head == back){
            head = null;
            back = null;
            length = 0;
            return;
        }
        // Loop through the list to go to Back -1 node
        // Alternatively we could have another variable secondLastNode
        // Which can be accessed in O(1) for now this is OK.
        Node<T> temp = head;
        while(temp.next != back){
            temp = temp.next;
        }
        // Remove the last node and update the back node and length
        temp.next = null;
        back = temp;
        length--;
    }

    // Remove a node at a particular index
    // Complexity O(n)
    public boolean removeIndex(int index){
        // Base condition
        if(index < 0){
            return false;
        }
        // Loop through the List
        Node<T> temp = head;
        while( index  != 1){
            if(temp == null){
                return false;
            }
            temp = temp.next;
            index --;
        }
        // If we have reached here then the next node is what we want to remove.
        Node<T> delete = temp.next;
        if(temp.next == back){
            temp.next = null;
            back = temp;
        }else{
            Node<T> delNode = temp.next;
            temp.next = delNode.next;
            delNode.next = null;
            delNode = null;
        }

        length --;
        return true;
    }

    // Create an array of the link list
    public T[] toArray(){
        // Base condition
        if(head == null){
            return (T[]) new Object[0];
        }
        // Create an array of same size as link list
        T[] array = (T[]) new Object[length];
        // Loop through the list and return the array
        Node<T> temp = head;
        int index = 0;
        while(temp != null){
            array[index] = temp.data;
            index ++;
            temp = temp.next;
        }
        return array;
    }

    // Find the first index of a data that we are searching for
    // Complexity O(n)
    public int indexOf(T data){
        // Base condition
        if(head == null){
            return -1;
        }

        // Loop through the list and return the index.
        int index = 0;
        Node<T> temp = head;
        while(temp != null){
            if(temp.data == data){
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    // Find the last index of a data that we are searching for
    // Complexity O(n)
    public int lastIndexOf(T data){
        // Base condition
        if(head == null){
            return -1;
        }
        // Loop through the entire list to find the last value.
        int index = -1;
        int lastIndex = -1;
        Node<T> temp = head;
        while(temp != null){
            if(temp.data == data){
                lastIndex = index;
            }
            index++;
            temp = temp.next;
        }
        return lastIndex;
    }

    // Check if the list contains a particular data
    public boolean contains(T data){
        // Base condition
        if(head == null){
            return false;
        }
        // Loop through the list and check if the data is present
        int index = 0;
        Node<T> temp = head;
        while(temp != null){
            if(temp.data == data){
                return true;
            }
            index++;
            temp = temp.next;
        }
        return false;
    }

    // Removes the first node which has a value of data
    // Complexity O(n)
    public boolean remove(T data){
        // Base condition
        if (head == null) {
            return false;
        }
        // Only one node exist and that node is data
        // Delete everything and return else just return false
        if(head == back){
            if(head.data == data){
                head = null;
                back = null;
                length = 0;
                return true;
            }
            return false;
        }

        // If first node = data then remove the head and return
        Node<T> temp = head;
        if(temp.data == data){
            temp = head.next;
            head.next = null;
            head = temp;
            return true;
        }
        // Loop through the list
        while( temp.next != null){
            if(temp.next.data == data){
                break;
            }
            temp = temp.next;
        }
        // We are now at place where the next node = data so we need to delete that node.
        Node<T> delete = temp.next;
        if(temp.next == back){
            temp.next = null;// If this is the last node
            back = temp;
        }else{
            Node<T> delNode = temp.next;
            assert delNode != null;
            temp.next = delNode.next;
            delNode.next = null;
            delNode = null;
        }

        length --;
        return true;
    }
    // endregion


}