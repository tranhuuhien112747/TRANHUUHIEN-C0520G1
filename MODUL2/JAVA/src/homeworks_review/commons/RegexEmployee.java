package homeworks_review.commons;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEmployee {
    static Scanner input = new Scanner(System.in);

    public static boolean checkCodeEmployee(String code) {
        final String CODE_REGEX = "^\\d{3,}-[A-Z]$";
        boolean isValid;
        Pattern pattern = Pattern.compile(CODE_REGEX);
        Matcher matcher = pattern.matcher(code);
        isValid = matcher.matches();
        return isValid;
    }

    public static boolean checkNameEmployee(String nameCustomer) {
        boolean isValid;
        final String NAME_REGEX = "^[A-Z][a-z]{0,}(([ ][A-Z][a-z]{0,})+)$";
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(nameCustomer);
        isValid = matcher.matches();
        return isValid;
    }

    public static boolean checkDate(String date) {
        boolean isValid;
        final String DATE31 = "^(([0][1-9]|[1-2][0-9]|[3][0-1])/([0][13578]|[1][02])";
        final String DATE30 = "|(0[1-9]|[1-2][0-9]|30)/([0][469]|12)";
        final String DATE2 = "|(0[1-9]|[1-2][0-9])/02)";
        final String YEAR = "/(190[1-9]{2}|19[1-9][0-9]|200[0-2])$";
        final String DATE = DATE31 + DATE30 + DATE2 + YEAR;
        //final String DATE_REGEX = "^(([0][1-9]|[1-2][0-9]|[3][0-1])/([0][13578]|[1][02])|(0[1-9]|[1-2][0-9]|30)/([0][469]|12)|(0[1-9]|[1-2][0-9])/02)/(190[1-9]{2}|19[1-9][0-9]|200[0-2])$";
        Pattern pattern = Pattern.compile(DATE);
        Matcher matcher = pattern.matcher(date);
        isValid = matcher.matches();
        return isValid;
    }
}
