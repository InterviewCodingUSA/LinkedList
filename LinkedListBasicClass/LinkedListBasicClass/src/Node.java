// Public class for node, this is templatized,
// I am making the data and the next node public for simple usage
public class Node <T> {
    public T data;
    public Node<T> next;

    public  Node(T data){
        this.data = data;
        this.next = null;
    }
}
