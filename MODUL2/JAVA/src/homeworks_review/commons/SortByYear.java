package homeworks_review.commons;

import homeworks_review.controller.Employee;

import java.util.Comparator;

public class SortByYear implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        int resuilt = o1.getNameSort(o1.getName()).compareTo(o2.getNameSort(o2.getName()));
        if (resuilt == 0) {
            return Integer.parseInt(o1.getYear(o1.getDateOfBirth())) - Integer.parseInt(o2.getYear(o2.getDateOfBirth()));

        }
        return resuilt;
    }
}
