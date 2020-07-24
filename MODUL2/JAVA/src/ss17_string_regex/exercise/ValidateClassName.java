package ss17_string_regex.exercise;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClassName {
    public static final String VALIDATE_NAME_CLASS_REGEX="^(C|A|P)[0-9]{4}[G-I|K-M]$";

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Pattern pattern=Pattern.compile(VALIDATE_NAME_CLASS_REGEX);
        System.out.println("Enter Class name's:");
        Matcher matcher=pattern.matcher(input.nextLine());
        if(matcher.matches()){
            System.out.println("OK");
        }else {
            System.err.println("Fail");
        }
    }
}
