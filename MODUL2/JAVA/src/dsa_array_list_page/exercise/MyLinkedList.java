package dsa_array_list_page.exercise;

import java.util.Arrays;

public class MyLinkedList<E> {
    private Node head;              // Phần tử đầu tiên trong linkedList.
    private int numNode = 0;        // Số lượng phần tử trong linkedList.

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }

    public MyLinkedList() {
    }

    public void addFist(E element) {
        //khai báo một biến temp trỏ đến heal.
        Node temp = head;
        //Biến heal nhận giá trị một node mới.
        head = new Node(element);
        //muốn chèn element vào phần tử đầu tiên thì phải trỏ heal.next đến temp.
        head.next = temp;
        numNode++;
    }

    public void addLast(E element) {
        //khai báo biến temp trỏ đến heal
        Node temp = head;
        //Cho con trỏ chạy đến phần tử cuối danh sách.
        while (temp.next != null) {
            //biến cuối cùng là temp.next.
            temp = temp.next;
        }
        //tạo node mới cho biến cuối cùng
        temp.next = new Node(element);
        numNode++;
    }

    public void add(int index, E element) {
        Node temp = head;
        Node holder;
        //cho con trỏ chạy tới vị trí index-1.
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;// vị trí index-1.
        }
        // cho biến holder tham chiếu đến vị trí index-1.
        holder = temp.next;
        //node vị trí index-1 sẽ trỏ tới node mới.
        temp.next = new Node(element);
        //node mới sẽ trỏ đến holder
        temp.next.next = holder;
        numNode++;
    }

    public E get(int index) {
        Node temp = head;
        //chạy vòng for để chạy đến vị trí index.
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        //trả về dữ liệu.
        return (E) temp.data;
    }

    public int size() {
        return numNode;
    }

    public E remove(int index) {
        if (index < 0 || index > numNode) {
            throw new IllegalArgumentException("NOT ERROR");
        }
        Object data;
        Node temp = head;
        if (index == 0) {
            //index=0 sẻ trả về data hiện tại.
            data = temp.data;
            //khi remove heal đầu tiên thì heal mới sẽ là heal tiếp theo
            head = head.next;
            numNode--;
        } else {
            for (int i = 0; i < index - 1 & temp.next != null; i++) {
                //phần tử tại index;
                temp = temp.next;
            }
            //trả về data của  node index.
            data = temp.next.data;
            //vì phần tử index(temp.next)bị xóa thì phần tử index-1 sẽ trỏ đến phần tử index+1.
            temp.next = temp.next.next;
            numNode--;
        }
        return (E) data;
    }

    public boolean remove(E element) {
        if (head.data.equals(element)) {
            remove(0);
            return true;
        } else {
            Node temp = head;
            while ((temp != null)) {
                //nếu như tồn tại một phần tử trong data truyền vào thì sẽ remove phần tử đó.
                if (temp.next.data.equals(element)) {
                    temp.next = temp.next.next;
                    numNode--;
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;


    }

    public MyLinkedList<E> clone() {
        //kiểm tra linkedlist có phần tử hay không
        if (numNode == 0) {
            throw new NullPointerException("Linkedlisst null");
        } else {
            MyLinkedList<E> myLinkedList = new MyLinkedList<>();
            Node temp = head;
            myLinkedList.addFist((E) temp.data);
            temp = temp.next;
            //chạy vòng lặp để đưa các phần tử danh sách cũ vào danh sách mới
            while (temp != null) {
                myLinkedList.addLast((E) temp.data);
                temp = temp.next;
            }
            return myLinkedList;
        }

    }

    public boolean contains(E element) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data.equals(element)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(E element) {
        Node temp = head;
        for (int i = 0; i < numNode && temp.next != null; i++) {
            if (temp.next.data.equals(element)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public void clear() {
        numNode = 0;
        for (int i = 0; i <numNode; i++) {
            head.data = null;
        }
    }

    public E getFist() {
        return (E) head.data;
    }

    public E getLast() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return (E) temp.data;
    }
}
