package homeworks_review.commons;

import homeworks_review.controller.Employee;

import java.util.Comparator;

public class SortByName implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.parseInt(o1.getYear(o1.getDateOfBirth())) - Integer.parseInt(o2.getYear(o2.getDateOfBirth()));
    }
}
