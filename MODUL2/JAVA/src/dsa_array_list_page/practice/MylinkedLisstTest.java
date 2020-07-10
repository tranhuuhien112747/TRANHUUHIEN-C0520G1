package dsa_array_list_page.practice;

public class MylinkedLisstTest {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(11);
        myLinkedList.addFirst(12);
        myLinkedList.addFirst(13);

        myLinkedList.add(4, 9);
        myLinkedList.add(2, 9);
        myLinkedList.printList();
    }
}
