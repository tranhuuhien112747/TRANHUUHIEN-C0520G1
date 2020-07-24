package ss17_string_regex.exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhoneNumber {
    public static final String VALIDATE_PHONE_NUMBER_REGEX="^\\([0-9]{2}+\\)-\\(0+[1-9]+[0-9]{8}\\)$";
    public static void main(String[] args) {
       Scanner scanner=new Scanner(System.in);
        Pattern pattern=Pattern.compile(VALIDATE_PHONE_NUMBER_REGEX);
        System.out.println("Enter number Phone:");
        Matcher matcher=pattern.matcher(scanner.nextLine());
        if(matcher.matches()){
            System.out.println("OK");
        }else {
            System.err.println("Fail");
        }
    }
}
