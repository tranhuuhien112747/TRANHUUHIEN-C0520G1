package access_modifier.practice;

public class StaticMethod {
    public static void main(String args[]) {
//creating objects
        Student.change();
        Student s1 = new Student(111, "Hoang");
        Student s2 = new Student(222, "Khanh");
        Student s3 = new Student(333, "Nam");
//calling display method
        s1.display();
        s2.display();
        s3.display();
        Student.change1();
        s1.display();
        s2.display();
        s3.display();
    }
}

class Student {
    private int rollno;
    private String name;
    private static String college = "BBDIT";

    //constructor to initialize the variable
    public Student(int r, String n) {
        this.rollno = r;
        this.name = n;
    }

    //static method to change the value of static variable
    static void change() {
        college = "CODEGYM";
    }
    static void change1() {
        college = "CODEGYMrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr";
    }
    //method to display values
    void display() {
        System.out.println(this.rollno + " " + this.name + " " + college);
    }
}
