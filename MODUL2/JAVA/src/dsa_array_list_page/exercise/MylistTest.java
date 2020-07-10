package dsa_array_list_page.exercise;

public class MylistTest {
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
        Student student1 = new Student(1, "Hùng");
        Student student2 = new Student(2, "Hoàng");
        Student student3 = new Student(3, "Hải");
        Student student4 = new Student(4, "Hoa");
        Student student5 = new Student(5, "Hậu");
        Student student6 = new Student(6, "Hien");
        MyList<Student> myList = new MyList<>();
        System.out.println("------------------------TEST ADDD--------------");
        myList.add(student1);
        myList.add(student2);
        myList.add(student3);
        myList.add(student4);
        myList.add(student5);
        myList.add(5, student6);
        myList.add(student6);
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i).toString());
        }
        System.out.println("-----------------------------------------------------");
        System.out.println(myList.get(3));
        System.out.println("------------------Remove------------------------------");
        System.out.println("remove index 6:" + myList.remove(4));
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i).toString());
        }
        System.out.println("-----------------------------------------");
        System.out.println(myList.indexOf(student2));
        System.out.println(myList.contains(student3));
        System.out.println("-----------------------------");
        MyList<Student> cloneMyList = myList.clone();
        for (int i = 0; i < cloneMyList.size(); i++) {
            System.out.println(cloneMyList.get(i).toString());
        }
        System.out.println("------------------------------");
        myList.clear();
        System.out.println(myList);

    }
}
