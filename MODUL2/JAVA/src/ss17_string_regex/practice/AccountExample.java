package ss17_string_regex.practice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountExample {
    public static final String ACCOUNT_REGEX = "^[_a-z0-9]{6,}$";

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Pattern pattern=Pattern.compile(ACCOUNT_REGEX);
        System.out.println("Enter Account: ");
        Matcher matcher=pattern.matcher(input.nextLine());
        if(matcher.matches()){
            System.out.println("OK!!");
        }else {
            System.err.println("Fail");
        }

    }
}
