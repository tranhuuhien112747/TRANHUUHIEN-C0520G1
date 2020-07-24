package text.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String x = "user@fpt.edu.vn";
        String y = "5\\d-[A-Z]\\d-((\\d{4})|(\\d{3}\\.\\d{2}))";
        if(x.matches(y)){
            System.out.print("A");
        }
        else{
            System.out.print("B");
        }
    }
}
