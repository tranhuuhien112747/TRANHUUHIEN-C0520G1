package text.demo;

import java.util.ArrayList;
import java.util.Collections;

public class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Nguyen Van Anh", 25);
        Student student2 = new Student(2, "Huỳnh Van Con", 20);
        Student student3 = new Student(3, "Nguyen Van Bung", 19);
        Student student4 = new Student(4, "Phạm Van Tin", 99);

        ArrayList myList = new ArrayList();
        myList.add(student1);
        myList.add(student2);
        myList.add(student3);
        myList.add(student4);

        for (Object object : myList) {
            System.out.println(object);
        }

        System.out.println("---------------------");
        Collections.sort(myList);

        for (Object object : myList) {
            System.out.println(object);
        }
    }
}
