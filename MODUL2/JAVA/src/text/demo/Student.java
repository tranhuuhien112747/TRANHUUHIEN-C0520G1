package text.demo;

public class Student implements Comparable {
    private int studentID;
    private String name;
    private int age;


    public Student(int studentID, String name, int age) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ID: " + studentID + " name: " + name + " age: " + age;
    }

    @Override
    public int compareTo(Object object) {
        Student otherStudent = (Student) object;
        //so sanh theo ten
        int result = this.name.compareTo(otherStudent.name);

        //hai ten bang nhau, thi so sanh theo tuoi
        if (result == 0) {
            if (this.age > otherStudent.getAge()) {
                return 1;
            } else if (this.age == otherStudent.getAge()) {
                return 0;
            } else {
                return -1;
            }
        }
        return result;
    }
}
