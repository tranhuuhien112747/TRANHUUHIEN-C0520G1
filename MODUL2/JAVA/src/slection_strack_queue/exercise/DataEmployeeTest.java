package slection_strack_queue.exercise;

import java.util.*;

/**
 * Test [Optional] [Bài tập] Tổ chức dữ liệu hợp lý - Demerging sử dụng Queue.
 */
public class DataEmployeeTest {
    public static void main(String[] args) {
        DataEmployee dataEmployee1 = new DataEmployee("Trần Văn B", "1990", "male");
        DataEmployee dataEmployee2 = new DataEmployee("Trần Văn D", "2000", "female");
        DataEmployee dataEmployee3 = new DataEmployee("Trần Văn K", "2003", "male");
        DataEmployee dataEmployee4 = new DataEmployee("Trần Văn H", "2004", "female");
        DataEmployee dataEmployee5 = new DataEmployee("Trần Văn A", "2006", "female");
        DataEmployee dataEmployee6 = new DataEmployee("Trần Văn C", "2008", "male");
        DataEmployee dataEmployee7 = new DataEmployee("Trần Văn Z", "2009", "male");
        List<DataEmployee> listEmployee = new ArrayList<>();
        listEmployee.add(dataEmployee1);
        listEmployee.add(dataEmployee2);
        listEmployee.add(dataEmployee3);
        listEmployee.add(dataEmployee4);
        listEmployee.add(dataEmployee5);
        listEmployee.add(dataEmployee6);
        listEmployee.add(dataEmployee7);
        System.out.println("Before-sort--------------------------------");
        for (int i = 0; i < listEmployee.size(); i++) {
            System.out.println(listEmployee.get(i) + "\t");
        }
//
        Deque<DataEmployee> female = new LinkedList<>();
        Deque<DataEmployee> male = new LinkedList<>();
        for (int i = 0; i < listEmployee.size(); i++) {
            if ("female".equals(listEmployee.get(i).getSex())) {
                female.add(listEmployee.get(i));
            } else {
                male.add(listEmployee.get(i));
            }
        }
        int count = 0;
        while (!female.isEmpty()) {
            listEmployee.set(count, female.pop());
            count++;
        }
        while ((!male.isEmpty())) {
            listEmployee.set(count, male.pop());
            count++;
        }
        System.out.println("Sort by sex -----------------------------------------------");
        for (int i = 0; i < listEmployee.size(); i++) {
            System.out.println(listEmployee.get(i));
        }
    }
}
