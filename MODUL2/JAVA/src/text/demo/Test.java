package text.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        Pattern p = Pattern.compile(".a");
        Matcher m = p.matcher("abs");
        boolean b = m.matches();
        System.out.println(b);
    }
}
