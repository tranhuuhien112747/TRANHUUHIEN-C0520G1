package access_modifier.homeworks;

public class StudentCodeGymClass {
    private static StudentCodeGym[] listStudent;
    private static int count = 0;

    static {
        listStudent = new StudentCodeGym[20];
    }
    public int getSize(){
        return count;
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
            System.out.print( listStudent[i].getId() + "\t" + listStudent[i].getName() + "\t"
                    + listStudent[i].getDayofBirth());
            System.out.println();
        }
    }
}
