package s00_case_study_furama_resot.commons;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCustomer {
    static Scanner input = new Scanner(System.in);

    /**
     * Name Customer must be in the first letter format and do not allow extra spaces.
     * If invalid, the message "Customer name must be capitalized first in each word" will appear.
     * ---------------------------------------CHECK NAME---------------------------------------------------------------
     */
    public static String checkNameFormat(String nameCustomer) {
        final String NAME_REGEX = "^[A-Z][a-z]{0,9}(([ ][A-Z][a-z]{0,9})+)$";
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(nameCustomer);
        while (!matcher.matches()) {
            System.err.println("Customer name must be capitalized first in each word ");
            System.out.println("Enter again:");
            nameCustomer = input.nextLine();
            matcher = pattern.matcher(nameCustomer);
        }
        return nameCustomer;
    }

    /**
     * Email includes only @ and at least 1 "."
     * If it is not valid, it will display the message "Email must be in abc@abc.abc format".
     * ---------------------------------------------CHECK EMAIL--------------------------------------------------------
     */
    public static String checkEmail(String email) {
        final String EMAIL_REGEX = "^\\w+@\\w+[.]\\w+$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        while (!matcher.matches()) {
            System.err.println("Email must be in abc@abc.abc format");
            System.out.println("Enter again:");
            email = input.nextLine();
            matcher = pattern.matcher(email);
        }
        return email;
    }

    /**
     * Force users to enter Male, Female or Unknown.
     * In the case of users entering the wrong uppercase or lowercase still accept but must standardize the correct
     * data before saving to the file.
     * -----------------------------------------CHECK GENDER----------------------------------------------------------
     */
    public static String checkGender(String gender) {
        final String GENDER_REGEX = "^(male|female|unknown)$";
        String data;
        while (gender.equals("")) {
            System.out.println("Enter gender customer(Male, Female or Unknown):");
            gender = input.nextLine().toLowerCase();
        }
        Pattern pattern = Pattern.compile(GENDER_REGEX);
        Matcher matcher = pattern.matcher(gender);
        while (!matcher.matches()) {
            System.err.println("Gender must be Male, Female or Unknown ");
            System.out.println("Enter again:");
            gender = input.nextLine().toLowerCase();
            matcher = pattern.matcher(gender);
        }
        data = gender.toUpperCase().charAt(0) + gender.substring(1);
        return data;
    }

    /**
     * Card Id must consist of 9 digits in the format XXX XXX XXX.
     * If false, then display the message "Id Card must be 9 digits and in the format XXX XXX XXX".
     * ---------------------------------------CHECK ID CARD------------------------------------------------------------
     */
    public static String checkIDCard(String idCard) {
        final String ID_CARD_REGEX = "^[1-9]\\d{8}$";
        Pattern pattern = Pattern.compile(ID_CARD_REGEX);
        Matcher matcher = pattern.matcher(idCard);
        while (!matcher.matches()) {
            System.err.println("Id Card must be 9 digits and in the format XXX XXX XXX ");
            System.out.println("Enter again:");
            idCard = input.nextLine();
            matcher = pattern.matcher(idCard);
        }
        return idCard;
    }

    /**
     * Birthday must have the correct date of birth in dd/MM/yyyy format and must have a birth year > 1900 and be 18
     * years younger than the current date.
     * If false, then display the message "The birth year must be > 1900 and 18 years younger than the current year,
     * correct format dd / mm / yyyy"
     * --------------------------------------CHECK DATE OF BIRTH---------------------------------------------------------
     */
    public static String checkDate(String date) {
        final String DATE31 = "^(([0][1-9]|[1-2][0-9]|[3][0-1])/([0][13578]|[1][02])";
        final String DATE30 = "|(0[1-9]|[1-2][0-9]|30)/([0][469]|12)";
        final String DATE2 = "|(0[1-9]|[1-2][0-9])/02)";
        final String YEAR = "/(190[1-9]{2}|19[1-9][0-9]|200[0-2])";
        final String DATE = DATE31 + DATE30 + DATE2 + YEAR;
        //final String DATE_REGEX = "^(([0][1-9]|[1-2][0-9]|[3][0-1])/([0][13578]|[1][02])|(0[1-9]|[1-2][0-9]|30)/([0][469]|12)|(0[1-9]|[1-2][0-9])/02)/(190[1-9]{2}|19[1-9][0-9]|200[0-2])$";
        Pattern pattern = Pattern.compile(DATE);
        Matcher matcher = pattern.matcher(date);
        while (!matcher.matches()) {
            System.err.println("The birth year must be > 1900 and 18 years younger than the current year correct format dd / mm / yyyy.");
            System.out.println("Enter again:");
            date = input.nextLine();
            matcher = pattern.matcher(date);
        }
        return date;
    }

    /**
     * Customer types include: Diamond, Platinum, Gold, Silver, Member.
     * -----------------------------------CHECK TYPE CUSTOMER-----------------------------------------------------------
     */
    public static String checkType(String typeCustomer) {
        final String TYPE_REGEX = "^(diamond|platinum|gold|silver|member)$";
        String data;
        while (typeCustomer.equals("")) {
            System.out.println("Enter type customer(Diamond, Platinum, Gold, Silver, Member):");
            typeCustomer = input.nextLine().toLowerCase();
        }
        Pattern pattern = Pattern.compile(TYPE_REGEX);
        Matcher matcher = pattern.matcher(typeCustomer);
        while (!matcher.matches()) {
            System.err.println("Type Customer must be(Diamond, Platinum, Gold, Silver, Member):");
            System.out.println("Enter again:");
            typeCustomer = input.nextLine().toLowerCase();
            matcher = pattern.matcher(typeCustomer);
        }
        data = typeCustomer.toUpperCase().charAt(0) + typeCustomer.substring(1);
        return data;
    }

    /**
     * Phone number includes 10 numbers. In the format 0XXXXXXXXX.
     * -----------------------------------------------CHECK PHONE NUMBER---------------------------------------------
     **/
    public static String checkPhone(String number) {
        final String NUMBER_PHONE_REGEX = "^[0][1-9]\\d{8}$";
        Pattern pattern = Pattern.compile(NUMBER_PHONE_REGEX);
        Matcher matcher = pattern.matcher(number);
        while (!matcher.matches()) {
            System.err.println("Phone number includes 10 numbers. In the format 0XXXXXXXXX.");
            System.out.println("Enter again: ");
            number = input.nextLine();
            matcher = pattern.matcher(number);
        }
        String data = number.substring(0, 4) + "." + number.substring(4, 7) + "." + number.substring(7);
        return data;
    }
}
