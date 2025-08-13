//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LinkList<Integer> list = new LinkList<>();
        list.sortedInsert(1);
        list.sortedInsert(2);
        list.sortedInsert(3);
        list.sortedInsert(4);
        list.sortedInsert(5);
        list.sortedInsert(6);

        list.printList();
        list.deleteMiddle();
        list.printList();
    }
}