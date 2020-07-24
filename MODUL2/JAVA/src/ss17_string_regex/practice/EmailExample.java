package ss17_string_regex.practice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExample {
    public static final String EMAIL_REGEX =   "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Pattern pattern=Pattern.compile(EMAIL_REGEX);
        System.out.println("Enter email: ");
        Matcher matcher=pattern.matcher(input.nextLine());
        if(matcher.matches()){
            System.out.println("Ok!");
        }else {
            System.err.println("FAILED");
        }

    }
}
