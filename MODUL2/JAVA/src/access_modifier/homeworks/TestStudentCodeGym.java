package access_modifier.homeworks;

import java.util.Scanner;

public class TestStudentCodeGym {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentCodeGym student1 = new StudentCodeGym(1, "Tran", "11/04/1996");
        StudentCodeGym student2 = new StudentCodeGym(2, "Huu", "11/05/1997");
        StudentCodeGym student3 = new StudentCodeGym(3, "Hien", "13/06/1997");
        StudentCodeGymClass listStudent = new StudentCodeGymClass();
        listStudent.register(student1);
        listStudent.register(student2);
        listStudent.register(student3);
        listStudent.displayListStudent();
        listStudent.graduate(2);
        listStudent.displayListStudent();
    }

    static class StudentCodeGym {
        private int id;
        private String name;
        private String dayofbirth;

        public StudentCodeGym(int id, String name, String dayofbirth) {
            this.id = id;
            this.name = name;
            this.dayofbirth = dayofbirth;
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

        public String getDayofBirth() {
            return dayofbirth;
        }

        public void setDayofBirth(String dayofbirth) {
            this.dayofbirth = dayofbirth;
        }
    }

    static class StudentCodeGymClass {
        private static StudentCodeGym[] listStudent;
        private static int count = 0;

        static {
            listStudent = new StudentCodeGym[20];
        }

        public int getIdStudent(int num) {
            return listStudent[num].getId();
        }

        public String getNameStudent(int num) {
            return listStudent[num].getName();
        }

        public String getDateOfBirthStudent(int num) {
            return listStudent[num].getDayofBirth();
        }

        public void register(StudentCodeGym student) {
            if (count > 20) {
                System.out.println("Class full");
            } else {
                System.out.println("Added successfully " + student.getName() + " on the list!");
                listStudent[count] = student;
                count++;
            }
        }

        public void graduate(int id) {
            for (int i = 0; i < listStudent.length - 1; i++) {
                if (listStudent[i].getId() == id) {
                    System.out.println("Congratulate " + listStudent[i].getName());
                    for (int j = i; j < listStudent.length - 1; j++) {
                        listStudent[j] = listStudent[j + 1];
                    }
                    break;
                }
            }
            listStudent[listStudent.length - 1] = null;
            count--;
        }

        public void displayListStudent() {
            System.out.println();
            for (int i = 0; i < count; i++) {
                System.out.print(i + 1 + "\t" + listStudent[i].getId() + "\t" + listStudent[i].getName() + "\t"
                        + listStudent[i].getDayofBirth());
                System.out.println();
            }
        }
    }
}