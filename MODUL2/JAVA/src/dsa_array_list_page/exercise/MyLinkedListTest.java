package dsa_array_list_page.exercise;

public class MyLinkedListTest {
    public static void main(String[] args) {
        class Student {
            private int id;
            private String name;

            public Student() {
            }

            public Student(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "Id = " + id + ", name = " + name;
            }
        }
        MyLinkedList<Student> myLinkedList = new MyLinkedList<>();
        Student student1 = new Student(1, "Hùng");
        Student student2 = new Student(2, "Hoàng");
        Student student3 = new Student(3, "Hải");
        Student student4 = new Student(4, "Hoa");
        Student student5 = new Student(5, "Hậu");
        Student student6 = new Student(6, "Hien");
        System.out.println("Test add--------------addFist--------------addLast");
        myLinkedList.addFist(student1);
        myLinkedList.addFist(student2);
        myLinkedList.addLast(student3);
        myLinkedList.addLast(student4);
        myLinkedList.addLast(student5);
        myLinkedList.add(3, student1);
        myLinkedList.addLast(student6);
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println(myLinkedList.get(i).toString() + "\t");
        }
        System.out.println("--------------------CLONE DANH SÁCH-----------------------------------");
        MyLinkedList<Student> cloneMyLinkedList = myLinkedList.clone();
        for (int i = 0; i < cloneMyLinkedList.size(); i++) {
            System.out.println(cloneMyLinkedList.get(i).toString());
        }

        System.out.println("--------------------------------------");
        System.out.println("Lấy Phần tử vị trí thứ 5 :" + "\n" + myLinkedList.get(5));
        System.out.println("--------------------------------------");
        System.out.println("Xóa phần tử vị trí 1: " + myLinkedList.remove(1));
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println(myLinkedList.get(i).toString() + "\t");
        }
        System.out.println("--------------------------------------");
        System.out.println("Xóa đối tượng student3:");
        myLinkedList.remove(student3);
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println(myLinkedList.get(i).toString() + "\t");
        }
        System.out.println("---------------------------------------------------");
        System.out.println("lấy phần tử đầu: " + myLinkedList.getFist());
        System.out.println("---------------------------------------------------");
        System.out.println("lấy phần tử cuối: " + myLinkedList.getLast());
        System.out.println("---------------------------------------------------");
        System.out.println("kiểm tra student3 trong danh sách " + myLinkedList.contains(student3));
        System.out.println("kiểm tra student4 trong danh sách " + myLinkedList.contains(student4));
        System.out.println("tìm kiếm student1 trong danh sách " + myLinkedList.indexOf(student1));
        System.out.println("------------------CLEAR---------------------");
        myLinkedList.clear();
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println(myLinkedList.get(i).toString() + "\t");
        }

    }
}
