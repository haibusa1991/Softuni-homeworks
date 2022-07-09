package Workshop01.DoublyLinkedList;


public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        for (int i = 0; i < 16; i++) {
            doublyLinkedList.addLast(i);
        }
        System.out.println();
        Integer[] wt = doublyLinkedList.toArray();
        System.out.println();

    }
}
