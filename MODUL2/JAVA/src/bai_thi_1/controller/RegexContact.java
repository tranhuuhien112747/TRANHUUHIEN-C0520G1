package bai_thi_1.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexContact {
    public static boolean checkEmail(String email) {
        boolean isValid;
        final String EMAIL_REGEX = "^\\w+@\\w+[.]\\w+$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        isValid = matcher.matches();
        return isValid;
    }

    public static boolean checkPhone(String phone) {
        boolean isValid;
        final String EMAIL_REGEX = "^[0][1-9]\\d{8}$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(phone);
        isValid = matcher.matches();
        return isValid;
    }
}
