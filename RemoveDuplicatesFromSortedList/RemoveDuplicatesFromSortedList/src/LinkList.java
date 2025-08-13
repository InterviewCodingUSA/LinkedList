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

    // Remove duplicates from the single link list.
    public void removeDuplicates(){
        if(head == null || head.next == null){
            return;
        }
        Node<T> temp = head;
        while(temp != null || temp.next != null){
            while(temp.next.data == temp.data){
                Node<T> del = temp.next;
                temp.next = temp.next.next;
                del = null;
                length --;
            }
            temp = temp.next;
        }
    }

    // Insert in link list in sorted manner.
    public void sortedInsert(T data){
        Node<T> add = new Node<>(data);
        // If list ie empty
        if(head == null){
            head = add;
            back = add;
            length = 1;
            return;
        }
        // check if there is just one node.
        if(head == back){
            if( head.data.compareTo(data) >=0 ){
                add.next = head;
                head = add;
                length++;
            }else{
                back = add;
                head.next = back;
                length ++;
            }
            return;
        }

        // If data is smaller than head.data
        if(head.data.compareTo(data) <=0){
            add.next = head;
            head = add;
            length ++;
            return;
        }
        Node<T> temp = head;
        while(temp.next.data.compareTo(data) <= 0){
            temp = temp.next;
        }
        add.next = temp.next;
        temp.next = add;
    }
}
