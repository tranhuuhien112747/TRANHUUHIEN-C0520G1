package javacollection_tree_and_map.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestComparatorAndComparable {
    public static void main(String[] args) {
        Student student1 = new Student("Hien", "DN", 20);
        Student student2 = new Student("Ban", "HN", 22);
        Student student3 = new Student("Phuong", "PY", 30);
        Student student4 = new Student("Toan", "H", 40);
        Student student5 = new Student("Khai", "QN", 25);
        List<Student> myList = new ArrayList<>();
        myList.add(student1);
        myList.add(student2);
        myList.add(student3);
        myList.add(student4);
        myList.add(student5);
        System.out.println("sort--------------------------------ByNAME---------------------------");
        Collections.sort(myList);
        for (Student student : myList) {
            System.out.println(student.toString());
        }
        System.out.println("sort---------------------ByAGE--------------------------------");
        AgeComparator ageComparator=new AgeComparator();
        Collections.sort(myList,ageComparator);
        for (Student student:myList){
            System.out.println(student.toString());
        }

    }
}
